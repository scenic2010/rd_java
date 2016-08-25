package scenic.study.designmode.behaviour_type.observer;

import scenic.MyLogger;
import scenic.study.designmode.behaviour_type.observer.abstract_core.Observable;
import scenic.study.designmode.behaviour_type.observer.abstract_core.Observer;

/**
 * Created by scenic on 16/8/10.
 */
public class Main extends MyLogger.TestWithLogger{


    public static void main(String args[]){
        new Main().run();
    }

    private void run() {
        Observer observer = () -> logger.info("update");

        Observable observable = new Observable() {
            @Override
            public void notifyObservers() {
                mObservers.forEach(Observer::update);
            }


        };

        observable.addObservers(observer);
        observable.notifyObservers();
    }
}
