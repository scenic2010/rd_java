package scenic.study.designmode.behaviour_type.observer.abstract_core;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by scenic on 16/8/10.
 */
public abstract class Observable {
    List<Observer> mObservers = new ArrayList<>();

    abstract void notifyObservers();

    public synchronized void addObservers(Observer observer) {
        if (!mObservers.contains(observer))
            mObservers.add(observer);
    }
}
