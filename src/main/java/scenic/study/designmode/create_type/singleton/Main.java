package scenic.study.designmode.create_type.singleton;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import scenic.MyLogger;

/**
 * Created by scenic on 16/8/9.
 * 单例模式
 */
public class Main {

    private static Logger logger = MyLogger.get(Main.class);
    public static void main(String args[]) {

        ExecutorService executor = Executors.newCachedThreadPool();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                logger.info(Singleton.getInstance());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };

        for(int i = 0; i < 100 ; i ++){

            executor.submit(runnable);
        }



        executor.shutdown();

    }
}
