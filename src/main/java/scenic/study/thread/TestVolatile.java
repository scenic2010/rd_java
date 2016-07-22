package scenic.study.thread;

import org.apache.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import scenic.MyLogger;

/**
 * Created by scenic on 16/4/26.
 */
public class TestVolatile {

    private static Logger logger = MyLogger.get(TestVolatile.class);


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        BlockingQueue<PlusNumberUtil> queue = new PriorityBlockingQueue<>();
        for(int i = 0; i < 1000; i++){
            queue.add(new PlusNumberUtil());
        }


        ExecutorService service = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; i++){
            WorkerThread workerThread = new WorkerThread(queue);
            service.submit(workerThread);
        }


        service.shutdown();

        if(service instanceof ThreadPoolExecutor){
            int cont = ((ThreadPoolExecutor) service).getActiveCount();
            while (cont != 0){
                cont = ((ThreadPoolExecutor) service).getActiveCount();
                waitForTime(10);
            }

        }

        logger.debug( "used time " +(System.currentTimeMillis() - start) + " number1 " + number1.get() + "\t number2 " + number2 +"\t number3 " + number3);
//        service.shutdownNow();
    }



    private static class WorkerThread extends Thread {

        private BlockingQueue<PlusNumberUtil> queue;

        public WorkerThread(BlockingQueue<PlusNumberUtil> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void work() throws InterruptedException {
            while (queue.size() > 0){
                PlusNumberUtil numberUtil = queue.take();
                numberUtil.plus1();
                numberUtil.plus2();
                numberUtil.plus3();
                logger.debug("isDaemon " + isDaemon()+ " number1 " + number1.get() + "\t number2 " + number2 +"\t number3 " + number3 + "\tqueue size " + queue.size());
            }
        }
    }

    public static AtomicInteger number1 = new AtomicInteger();
    public volatile static int number2 = 0;
    public volatile static int number3 = 0;

    private static class PlusNumberUtil implements Comparable{

        public void plus1(){
            waitForTime(10);
            number1.getAndAdd(1);
        }

        public void plus2(){
            waitForTime(10);
            number2++;
        }
        public void plus3(){
            waitForTime(10);
            number3++;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    private static void waitForTime(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
