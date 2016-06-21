package scenic.thread.common;

/**
 * Created by scenic on 16/6/6.
 */
public class TestPriority {


    public static void main(String args[]) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
//        thread1.setPriority(Thread.NORM_PRIORITY + 5);
        thread1.start();
        thread2.start();

    }


    private static class MyThread1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i + "\t t1");
            }
        }
    }


    public static class MyThread2 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i + "\tt2=========================");
            }
        }
    }

}
