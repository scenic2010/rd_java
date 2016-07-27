package scenic.study.designmode.prototype;

import java.util.Vector;

/**
 * Created by scenic on 16/7/22.
 */
public class TrashVector extends Vector<Trash>{
    private Class type;

    public TrashVector(Class type) {
        this.type = type;
    }

    public Class getType() {
        return type;
    }

    public boolean grab(Trash t){
        if(t.getClass().equals(type)){
            add(t);
            return true;
        }
        return false;
    }



}
