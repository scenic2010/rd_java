package scenic.thread.synchronizedandlock;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

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

    /**
     * 选择静态还是每次创建新的对象
     */
    static int debugFlag1 = 0;

    /**
     * 选择不同的逻辑方式
     */
    static int debugFlag2 = 1;


    @Test
    public void testClassObject() {
        SynchronizedAndLock insance1 = new SynchronizedAndLock();
        SynchronizedAndLock insance2 = new SynchronizedAndLock();
        logger.info("the SynchronizedAndLock Class object equals " + insance1.getClass().equals(insance2.getClass()));
        logger.info(SynchronizedAndLock.class.equals(this.getClass()));
    }


    public static void main(String args[]) throws InterruptedException {
        logger.setLevel(Level.INFO);


        BlockingQueue<Tacker> blockingQueue = new PriorityBlockingQueue<>();
        for (int i = 0; i < 60; i++) {
            WorkTask workTask = new WorkTask(blockingQueue);
            workTask.start();
        }


        for (int i = 0; i < 100; i++) {
            Tacker tacker;
            switch (debugFlag1) {
                case 0:
                    tacker = Tacker.getInstance();
                    break;
                case 1:
                    tacker = new Tacker();
                    break;
                default:
                    throw new RuntimeException("debugFlag1 not right selected");
            }

            blockingQueue.add(tacker);
        }

    }

    private static class WorkTask extends Thread {
        BlockingQueue<Tacker> blockingQueue;
        WorkTask(BlockingQueue bq) {
            blockingQueue = bq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    logger.debug("begin take");
                    Tacker object = blockingQueue.take();

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
                    e.printStackTrace();
                }
            }
        }
    }


    private static class Tacker implements Comparable {
        private static Integer value = 0;
        private static Lock lock = new ReentrantLock();

        private static Tacker instance;

        public Tacker() {
            logger.debug("the class object " + getClass() + "  " + getClass().getClassLoader() + "  ");
            logger.info("create tacker " + this);
        }

        public static Tacker getInstance() throws InterruptedException {
            synchronized (Tacker.class) {
                if (instance == null) {

                    Thread.sleep(100);
                    instance = new Tacker();
                }
                return instance;
            }
        }

        public void addNotSafe() {
            internalAdd();
        }

        public void addBySynchronized() {
            synchronized (Tacker.class) {
                internalAdd();
                if (value == 50) {
                    throw new RuntimeException("线程抛出异常,synchronized,自动释放锁");
                }
            }

        }

        public void addByLock() {
            lock.lock();
            internalAdd();
            if (value == 50) {
                throw new RuntimeException("线程抛出异常,Lock,不会自动释放锁");
            }
            lock.unlock();
        }

        public void addByLockWidthTryFinally() {
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

        private void internalAdd() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            value++;
            logger.info("the value is " + value);

        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
