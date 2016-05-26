package scenic.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by scenic on 16/4/21.
 */
public class ExecutorServiceTest {

    public static void main(String args[]){
        new ExecutorServiceTest().myRun();
    }

    public void myRun() {

        Executor executor;
        ExecutorService service = Executors.newCachedThreadPool();
        Future<?> tmp = service.submit(mCallable);

        service.shutdown();
        service.submit(myRunnable);

        try {
            System.out.println(tmp.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println(Thread.currentThread().getName());
    }

    Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() +  "myRunnable begin execute");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +  "myRunnable execute finish");

        }
    };

    FutureTask<String> mFutureTask = new FutureTask<String>(myRunnable,"success");

    Callable<String> mCallable = new Callable<String>(){

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() +  "mCallable execute finish");
            Thread.sleep(1000);
            return "call return";
        }
    };

}
