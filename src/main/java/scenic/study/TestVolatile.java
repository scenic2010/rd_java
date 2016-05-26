package scenic.study;

/**
 * Created by scenic on 15/8/16.
 */
public class TestVolatile {
    public static void main(String[] args) throws Exception
    {

        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++)
            // 建立100个线程
            threads[i] = new JoinThread();
        for (int i = 0; i < threads.length; i++)
            // 运行刚才建立的100个线程
            threads[i].start();
        for (int i = 0; i < threads.length; i++){
            // 100个线程都执行完后继续
            System.out.println(threads[i].getName() + " join start ");
            threads[i].join();
            System.out.println(threads[i].getName() + " join end ");
        }
        System.out.println("n=" + JoinThread.n);
    }
}

 class JoinThread extends Thread
{
    public static int n = 0;
    public void run()
    {
        for (int i = 0; i < 10; i++)
            try
            {
//                n = n + 1;
                init();
                sleep(3); // 为了使运行结果更随机，延迟3毫秒

            }
            catch (Exception e)
            {
            }
        System.out.println(getName() + " finish ");
    }

     static  synchronized void init(){
        n++;
    }

}