package scenic.study.thread.synchronizedandlock;

import scenic.MyLogger;

/**
 * Created by scenic on 2016/8/24.
 */
public class TestMuchThreadAffect extends MyLogger.TestWithLogger{

    public static void main(String args[]){

            new TestMuchThreadAffect().run();

    }

    public void run() {
        new Thread(this::testMethod,"name 1").start();
        new Thread(this::testMethod,"name 2").start();
    }



    public void testMethod(){

        Thread thread = Thread.currentThread();
        System.out.println(thread);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug(thread.getName());


    }

}
