package scenic.study.designmode.prototype;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Created by scenic on 16/7/22.
 */
public abstract class Trash {
    private final double weight;

    public Trash(double wt){
        this.weight = wt;
    }

    public abstract int value();

    public double getWeight() {
        return weight;
    }

    public static double sumValue(Vector<Trash> vector){
        double sum = 0;
        for (Trash t : vector) {
            sum+=(t.getWeight() * t.value());
        }
        return sum;
    }



    private static Vector<Class> trashTypes = new Vector<>();

    /**
     *
     * @return
     * @since solution2
     */
    public static Trash facotry(Info info){

        for (Class c: trashTypes) {
            if(c.getName().indexOf(info.name) != -1){
                try {
                    return (Trash) c.getConstructor(double.class).newInstance(info.weight);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    return null;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        try {
            trashTypes.add(Class.forName(info.name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return facotry(info);
    }

    public static final class Info{
        public String name;
        public double weight;

        public String getName() {
            return name;
        }

        public Info setName(String name) {
            this.name = name;
            return this;
        }

        public double getWeight() {
            return weight;
        }

        public Info setWeight(double weight) {
            this.weight = weight;
            return this;
        }
    }


}
