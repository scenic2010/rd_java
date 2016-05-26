package scenic.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by scenic on 16/4/26.
 */
public class TestVolatile {

    public volatile static int count1 = 0;
    public volatile static int count2 = 0;

    public static AtomicInteger count3 = new AtomicInteger();

    public  static void plus(){
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count3.getAndAdd(1);

        count2++;
        synchronized (TestVolatile.class){
            count1++;
        }
    }

    public static void main(String args[]){
        for(int i = 0;i < 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    plus();
                }
            }).start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count1 is "+ count1);
        System.out.println("count1 is "+ count2);
        System.out.println("count1 is "+ count3.get());
    }
}
