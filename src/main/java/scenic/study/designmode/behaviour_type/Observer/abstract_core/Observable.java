package scenic.study.designmode.behaviour_type.Observer.abstract_core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scenic on 16/8/10.
 */
public abstract class Observable {
    List<Observer> mObjservers = new ArrayList<>();

    abstract void notifyObservers();

    public synchronized void addObservers(Observer observer) {
        if (!mObjservers.contains(observer))
            mObjservers.add(observer);
    }
}
