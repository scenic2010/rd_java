package scenic.thread;

import org.apache.log4j.Logger;

import scenic.MyLogger;

/**
 * Created by scenic on 16/6/6.
 * 这里模拟了生产者和消费者的模型
 */
public class ProductAndCustom {

    private static Logger myLogger = MyLogger.get(ProductAndCustom.class);

    public static void main(String args[]) {
        SyncStack syncStack = new SyncStack();

        new Product(syncStack, "aaa").start();
        new Product(syncStack, "bbb").start();
        new Product(syncStack, "ccc").start();


        new Customer(syncStack, "消费1").start();


    }

    private static class TestEntity {
        private String id;
        public TestEntity(String id) {
            this.id = id;
        }
    }

    private static class SyncStack {
        private static Object lock = new Object();
        static final int entitiesSize = 6;

        int index = 0;

        TestEntity[] entities = new TestEntity[entitiesSize];

        public void push(TestEntity entity) throws InterruptedException {
            synchronized (lock) {
                while (index == entities.length) {
                    myLogger.debug(" collection full, pause the push");
                    lock.wait();
                }
                lock.notifyAll();

                internalPush(entity);
            }
        }

        private void internalPush(TestEntity entity){
            entities[index] = entity;
            index++;
            myLogger.debug("生产了 " + entity.id + "=====" + this.index);
        }

        private void internalPop(){
            index--;
            myLogger.debug("消费了 " + entities[index].id + " sync stack size ------------------------" + index);
            System.out.println();
            System.out.println();
        }

        public TestEntity pop() throws InterruptedException {
            synchronized (lock) {
                while (index == 0) {
                    lock.wait();
                }
                lock.notifyAll();

                internalPop();
                return entities[index];
            }

        }
    }

    private static class Product extends Thread {

        private SyncStack syncStack;

        public static int allCont = 0;

        Product(SyncStack syncStack, String name) {
            super(name);
            this.syncStack = syncStack;
            allCont += 20;
        }


        @Override
        public void run() {

            for (int i = 0; i < 20; i++) {
                try {
                    String id = getName() + "_" + i;
                    syncStack.push(new TestEntity(id));

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Customer extends Thread {
        private SyncStack syncStack;

        Customer(SyncStack syncStack, String name) {
            super(name);
            this.syncStack = syncStack;
        }

        @Override
        public void run() {
            for (int i = 0; i < Product.allCont; i++) {
                TestEntity entity;
                try {
                    entity = syncStack.pop();
                    Thread.sleep(100);
                    System.out.println(entity.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

