package scenic.study.designmode.create_type.prototype.solution5;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import scenic.study.designmode.create_type.prototype.Trash;
import scenic.study.designmode.create_type.prototype.solution3.Fillable;

/**
 * Created by scenic on 16/7/25.
 */
public class DynamicTrash {
    private Map<Class,Vector<Trash>> types = new Hashtable<>();

    private void add(Trash trash){

        Class type = trash.getClass();

        if(types.containsKey(type)){
            types.get(type).add(trash);
        }else {
            Vector<Trash> v = new Vector<>();
            v.add(trash);
            types.put(type,v);
        }

    }

    public Vector get(Class type){
        return types.get(type);
    }

    public Set<Class> keys(){
        return types.keySet();
    }

    public Collection<Vector<Trash>> valus(){
        return types.values();
    }

    public Fillable fillable(){
        return t -> add(t);
    }

}
