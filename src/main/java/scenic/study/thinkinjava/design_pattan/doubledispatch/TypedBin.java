//: TypedBin.java
// Vector that knows how to grab the right type
package scenic.study.thinkinjava.design_pattan.doubledispatch;

import java.util.Enumeration;
import java.util.Vector;

import scenic.study.thinkinjava.design_pattan.trash.Trash;

public abstract class TypedBin {
    Vector v = new Vector();

    protected boolean addIt(Trash t) {
        v.addElement(t);
        return true;
    }

    public Enumeration elements() {
        return v.elements();
    }

    public boolean add(DDAluminum a) {
        return false;
    }

    public boolean add(DDPaper a) {
        return false;
    }

    public boolean add(DDGlass a) {
        return false;
    }

    public boolean add(DDCardboard a) {
        return false;
    }
} ///:~