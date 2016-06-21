package scenic.thread;

import org.apache.log4j.Logger;

import java.io.IOException;

import scenic.MyLogger;

/**
 * Created by scenic on 16/4/26.
 * 测试守护进程,主线程结束之后,守护线程自动结束
 */
public class TestDemonThread {

    private static Logger myLogger = MyLogger.get(TestDemonThread.class);

    public static void main(String[] args) throws IOException {
        MaybeDaemonThread maybeDaemonThread = new MaybeDaemonThread();

        int selected = 0;
        switch (selected){
            case 0:
                //如果不设置daemon，那么线程将输出100后才结束
                maybeDaemonThread.setDaemon(true);
                break;
            case 1:
                break;
        }

        maybeDaemonThread.start();
        myLogger.debug("isDaemon = " + maybeDaemonThread.isDaemon());

        myLogger.debug("you can type some word");
        // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
        System.in.read();

        myLogger.debug("the main thread finish\n");
    }


    private static class MaybeDaemonThread extends Thread {

        /**
         * 线程的run方法，它将和其他线程同时运行
         */
        public void run() {

            for (int i = 1; i <= 1000; i++) {
                waitTime(1000);
                myLogger.debug("MaybeDaemonThread thread running " + i);
            }
        }


        private void waitTime(int time){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


