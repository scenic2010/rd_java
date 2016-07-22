package scenic.study.thinkinjava.io;//: c11:DirList.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Displays directory listing.

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import scenic.study.thinkinjava.bruceeckel.util.AlphabeticComparator;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list,
                new AlphabeticComparator());
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}

class DirFilter implements FilenameFilter {
    String afn;

    DirFilter(String afn) {
        this.afn = afn;
    }

    public boolean accept(File dir, String name) {
        // Strip path information:
        String f = new File(name).getName();
        return f.indexOf(afn) != -1;
    }
} ///:~