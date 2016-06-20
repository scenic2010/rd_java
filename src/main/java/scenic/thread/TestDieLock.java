package scenic.thread;

/**
 * Created by scenic on 16/6/6.
 */
public class TestDieLock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String args[]) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();

    }


    public static class Thread1 extends Thread {
        @Override
        public void run() {

            synchronized (lock1) {
                System.out.println("t1 get the lock1");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 want the lock2");
                synchronized (lock2) {
                    System.out.println("t1 run execute finish");
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("t2 get the lock2");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 want the lock1");
                synchronized (lock1) {
                    System.out.println("t1 run execute finish");
                }
            }
        }
    }


}
