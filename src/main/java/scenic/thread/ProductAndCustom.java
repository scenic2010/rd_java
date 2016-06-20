package scenic.thread;

/**
 * Created by scenic on 16/6/6.
 */
public class ProductAndCustom {


    public static void main(String args[]) {
        SyncStack syncStack = new SyncStack();

        new Product(syncStack, "aaa").start();
        new Product(syncStack, "bbb").start();
        new Product(syncStack, "ccc").start();


        new Customer(syncStack, "消费1").start();


    }

    private static class WoTo {
        private String id;

        public WoTo(String id) {
            this.id = id;
        }
    }

    private static class SyncStack {
        int index = 0;
        WoTo[] woTos = new WoTo[6];

        private Object lock = new Object();

        public void push(WoTo woto) throws InterruptedException {
            synchronized (lock) {
                while (index == woTos.length) {
                    System.out.println(Thread.currentThread().getName() + " wait ");
                    lock.wait();
                }

                lock.notifyAll();
                woTos[index] = woto;
                index++;

                System.out.println(Thread.currentThread().getName() + "\t生产了 " + woto.id + "=====" + this.index);
            }

        }

        public WoTo pop() throws InterruptedException {

            synchronized (lock) {
                while (index == 0) {
                    lock.wait();
                }
                lock.notifyAll();
                index--;
                System.out.println(Thread.currentThread().getName() + "\t消费了 " + woTos[index].id + " sync stack size ------------------------" + index);
                System.out.println();
                System.out.println();
                return woTos[index];
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
                    syncStack.push(new WoTo(id));

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
                WoTo woto;
                try {
                    woto = syncStack.pop();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

