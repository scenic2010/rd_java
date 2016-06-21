package scenic.thread.common;

import org.apache.log4j.Logger;

import scenic.MyLogger;

/**
 * Created by scenic on 16/6/6.
 * 死锁的模型
 */
public class TestDieLock {
    private static Logger myLogger = MyLogger.get(TestDieLock.class);

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String args[]) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

    }


    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                myLogger.debug("Thread1 get the lock1");
                waitForTime(1);
                myLogger.debug("Thread1 want the lock2");
                synchronized (lock2) {
                    System.out.println("t1 run execute finish");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                myLogger.debug("Thread2 get the lock2");
                waitForTime(1);

                myLogger.debug("Thread2 want the lock1");
                synchronized (lock1) {
                    System.out.println("t1 run execute finish");
                }
            }
        }
    }

    private static void waitForTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
