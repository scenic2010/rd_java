package scenic.thread.pool;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import scenic.MyLogger;

/**
 * Created by scenic on 16/4/21.
 */
public class ExecutorServiceTest {

    private static Logger logger = MyLogger.get(ExecutorServiceTest.class);


    public static void main(String args[]) {
        new ExecutorServiceTest().myRun();
    }


    @Test
    public void testExecuteServiceSubmit() throws ExecutionException, InterruptedException {
        //测试 ExecuteService submit 方法
        ExecutorService executorService = Executors.newCachedThreadPool();
        logger.debug("execute service is " + executorService);
        Future<?> future = executorService.submit(mCallable);

        Object futureGetValue = future.get();
        logger.debug("futureGetValue is " + futureGetValue);

    }

    public void myRun() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> tmp = executorService.submit(mCallable);

        executorService.submit(myRunnable);

        try {
            logger.debug(tmp.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        logger.debug(Thread.currentThread().getName());
    }






    Runnable myRunnable = () -> {
        logger.debug(Thread.currentThread().getName() + "myRunnable begin execute");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.debug(Thread.currentThread().getName() + "myRunnable execute finish");

    };

    FutureTask<String> mFutureTask = new FutureTask<>(myRunnable, "success");

    Callable<String> mCallable = () -> {
        String name = Thread.currentThread().getName();
        Thread.sleep(1000);
        logger.debug(name + " mCallable execute finish");
        return "mCallable return " + name;
    };

}
