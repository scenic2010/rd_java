package scenic.thread;

/**
 * Created by scenic on 16/6/6.
 */
public class TestSync implements Runnable {

    static Timer timer = new Timer();


    public static void main(String args[]) {

        TestSync testSync = new TestSync();
        Thread t1 = new Thread(testSync);
        Thread t2 = new Thread(testSync);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();


//        timer.m1();
//        timer.m2();
    }

    @Override
    public void run() {
        try {
            timer.add(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Timer {
        private static int num1 = 0;

        public void add(String name) throws InterruptedException {
            synchronized (this) {
                num1++;
                Thread.sleep(1);
                System.out.println(name + " ,你是第 " + num1 + " 个使用time的线程 ");
            }
        }

        public synchronized void m1() {
            num1 = 1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void m2() {
            System.out.println(num1);
        }

    }

}
