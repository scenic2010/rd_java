//: RecycleAP.java 
// Recycling with RTTI and Prototypes
package scenic.study.thinkinjava.design_pattan.recycleap;

import java.util.Enumeration;
import java.util.Vector;

import scenic.study.thinkinjava.design_pattan.trash.Aluminum;
import scenic.study.thinkinjava.design_pattan.trash.Glass;
import scenic.study.thinkinjava.design_pattan.trash.Paper;
import scenic.study.thinkinjava.design_pattan.trash.ParseTrash;
import scenic.study.thinkinjava.design_pattan.trash.Trash;

public class RecycleAP {
    public static void main(String[] args) {
        Vector bin = new Vector();
        // Fill up the Trash bin:
        ParseTrash.fillBin("Trash.dat", bin);
        Vector
                glassBin = new Vector(),
                paperBin = new Vector(),
                alBin = new Vector();
        Enumeration sorter = bin.elements();
        // Sort the Trash:
        while (sorter.hasMoreElements()) {
            Object t = sorter.nextElement();
            // RTTI to show class membership:
            if (t instanceof Aluminum)
                alBin.addElement(t);
            if (t instanceof Paper)
                paperBin.addElement(t);
            if (t instanceof Glass)
                glassBin.addElement(t);
        }
        Trash.sumValue(alBin);
        Trash.sumValue(paperBin);
        Trash.sumValue(glassBin);
        Trash.sumValue(bin);
    }
} ///:~