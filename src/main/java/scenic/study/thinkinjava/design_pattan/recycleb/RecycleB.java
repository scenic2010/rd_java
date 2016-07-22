//: RecycleB.java
// Adding more objects to the recycling problem
package scenic.study.thinkinjava.design_pattan.recycleb;

import java.util.Enumeration;
import java.util.Vector;

import scenic.study.thinkinjava.design_pattan.trash.Aluminum;
import scenic.study.thinkinjava.design_pattan.trash.Cardboard;
import scenic.study.thinkinjava.design_pattan.trash.Glass;
import scenic.study.thinkinjava.design_pattan.trash.Paper;
import scenic.study.thinkinjava.design_pattan.trash.ParseTrash;
import scenic.study.thinkinjava.design_pattan.trash.Trash;

// A vector that admits only the right type:
class TBin extends Vector {
    Class binType;

    TBin(Class binType) {
        this.binType = binType;
    }

    boolean grab(Trash t) {
        // Comparing class types:
        if (t.getClass().equals(binType)) {
            addElement(t);
            return true; // Object grabbed
        }
        return false; // Object not grabbed
    }
}

class TBinList extends Vector { //(*1*)
    boolean sort(Trash t) {
        Enumeration e = elements();
        while (e.hasMoreElements()) {
            TBin bin = (TBin) e.nextElement();
            if (bin.grab(t)){
                return true;
            }

        }
        return false; // bin not found for t
    }

    void sortBin(TBin bin) { // (*2*)
        Enumeration e = bin.elements();
        while (e.hasMoreElements()){
            Trash trash = (Trash) e.nextElement();
            if (!sort(trash)){
                System.out.println("Bin not found");
            }

        }

    }
}

public class RecycleB {
    static TBin bin = new TBin(Trash.class);

    public static void main(String[] args) {
        // Fill up the Trash bin:
        ParseTrash.fillBin("Trash.dat", bin);

        TBinList trashBins = new TBinList();
        trashBins.addElement(
                new TBin(Aluminum.class));
        trashBins.addElement(
                new TBin(Paper.class));
        trashBins.addElement(
                new TBin(Glass.class));
        // add one line here: (*3*)
        trashBins.addElement(
                new TBin(Cardboard.class));

        trashBins.sortBin(bin); // (*4*)

        Enumeration e = trashBins.elements();
        while (e.hasMoreElements()) {
            TBin b = (TBin) e.nextElement();
            Trash.sumValue(b);
        }
        Trash.sumValue(bin);
    }
} ///:~