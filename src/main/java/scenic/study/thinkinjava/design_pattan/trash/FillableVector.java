//: FillableVector.java 
// Adapter that makes a Vector Fillable
package scenic.study.thinkinjava.design_pattan.trash;

import java.util.*;

public class FillableVector implements Fillable {
    private Vector v;

    public FillableVector(Vector vv) {
        v = vv;
    }

    public void addTrash(Trash t) {
        v.addElement(t);
    }
} ///:~