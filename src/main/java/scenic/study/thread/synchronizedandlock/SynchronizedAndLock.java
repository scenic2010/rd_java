package scenic.study.thread.synchronizedandlock;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import scenic.MyLogger;


/**
 * Created by scenic on 16/6/21.
 * 这里主要是测试 synchronized 和 lock的使用方法,已经他们的区别
 */
public class SynchronizedAndLock {

    private static Logger logger = MyLogger.get(SynchronizedAndLock.class);

    static {
        logger.setLevel(Level.INFO);
    }

    /**
     * 选择静态还是每次创建新的对象
     */
    static int debugFlag1 = 0;

    /**
     * 选择不同的逻辑方式
     */
    static int debugFlag2 = 2;


    @Test
    public void testClassObject() {
        SynchronizedAndLock instance1 = new SynchronizedAndLock();
        SynchronizedAndLock instance2 = new SynchronizedAndLock();
        logger.info("the SynchronizedAndLock Class object equals " + instance1.getClass().equals(instance2.getClass()));
        logger.info(SynchronizedAndLock.class.equals(this.getClass()));
    }




    public static void main(String args[]) throws InterruptedException {

        BlockingQueue<IntegerAdder> blockingQueue = new PriorityBlockingQueue<>();


        List<WorkTask> workTaskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WorkTask workTask = new WorkTask(blockingQueue,"task:" + i);
            workTask.start();
            workTaskList.add(workTask);
        }


        for (int i = 0; i < 100; i++) {
            IntegerAdder tacker;
            switch (debugFlag1) {
                case 0:
                    tacker = IntegerAdder.getInstance();
                    break;
                case 1:
                    tacker = new IntegerAdder();
                    break;
                default:
                    throw new RuntimeException("debugFlag1 not right selected");
            }

            blockingQueue.add(tacker);
        }


        while (blockingQueue.size() != 0) {
            Thread.sleep(100);
        }

        workTaskList.forEach(WorkTask::interrupt);
    }

    private static class WorkTask extends Thread {
        BlockingQueue<IntegerAdder> blockingQueue;

        WorkTask(BlockingQueue bq,String name) {
            super(name);
            blockingQueue = bq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    logger.debug("begin take");
                    IntegerAdder object = blockingQueue.take();

                    switch (debugFlag2) {
                        case 0:
                            object.addNotSafe();
                            break;
                        case 1:
                            object.addBySynchronized();
                            break;
                        case 2:
                            object.addByLock();
                            break;
                        case 3:
                            object.addByLockWidthTryFinally();
                            break;
                    }


                    logger.debug("finish take " + object);

                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    logger.info("WorkTask exit");
                    break;
                }
            }
        }
    }

    private static class IntegerAdder implements Comparable {
        private static Integer value = 0;
        private static Lock lock = new ReentrantLock();

        private static IntegerAdder instance;

        public IntegerAdder() {
            logger.debug("the class object " + getClass() + "  " + getClass().getClassLoader() + "  ");
            logger.info("create tacker " + this);
        }

        public static IntegerAdder getInstance() throws InterruptedException {
            synchronized (IntegerAdder.class) {
                if (instance == null) {

                    Thread.sleep(100);
                    instance = new IntegerAdder();
                }
                return instance;
            }
        }

        /**
         * 多线程下,不安全的增加
         */
        public void addNotSafe() throws InterruptedException {
            internalAdd();
        }

        public void addBySynchronized() throws InterruptedException {
            synchronized (IntegerAdder.class) {
                internalAdd();
                if (value == 50) {
                    throw new RuntimeException("线程抛出异常,synchronized,自动释放锁");
                }
            }
        }

        public void addByLock() throws InterruptedException {
            lock.lock();
            internalAdd();
            if (value == 50) {
                throw new RuntimeException("线程抛出异常,Lock,不会自动释放锁");
            }
            lock.unlock();
        }

        public void addByLockWidthTryFinally() throws InterruptedException {
            lock.lock();
            try {
                internalAdd();
                if (value == 50) {
                    throw new RuntimeException("线程抛出异常,Lock,不会自动释放锁");
                }
            } finally {
                lock.unlock();
            }
        }

        private void internalAdd() throws InterruptedException {
            Thread.sleep(100);
            value++;
            logger.info("the value is " + value);

        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
