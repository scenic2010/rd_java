package scenic.study.basic_knowledge;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

import scenic.MyLogger;

/**
 * Created by scenic on 16/7/21.
 */
public class JavaObservableTest {


    private static Logger logger = MyLogger.get(JavaObservableTest.class);

    private static class MyObservable extends Observable {
        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    }

    @Test
    public void testExecuteObservable(){
        Observable observable = new MyObservable() ;
        observable.addObserver(new MyObserver1());
        observable.addObserver(new MyObserver2());
        observable.notifyObservers(3);
    }



    class MyObserver1 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            logger.info("update " + o + "arg " + arg);
        }
    }
    class MyObserver2 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            logger.info("update " + o + "arg " + arg);
        }
    }
}
