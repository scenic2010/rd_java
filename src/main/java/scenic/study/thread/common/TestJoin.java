package scenic.study.thread.common;

import org.apache.log4j.Logger;

import scenic.MyLogger;

/**
 * Created by scenic on 16/6/6.
 */
public class TestJoin {
    private static Logger logger = MyLogger.get(TestDieLock.class);

    public static void main(String args[]) throws InterruptedException {

        MyThread2 t1 = new MyThread2("t1");
        t1.start();

        t1.join();
        for (int i = 0; i < 10; i++) {
            logger.info("i am main thread");
        }
    }

    private static class MyThread2 extends Thread {
        MyThread2(String name) {
            super(name);
        }

        public void run(){
            for (int i = 0; i < 10; i++) {
                logger.info("i am " + getName() + "\t\t" + Thread.currentThread().getName());

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

