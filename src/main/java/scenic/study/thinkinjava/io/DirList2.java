package scenic.study.thinkinjava.io;//: c11:DirList2.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Uses anonymous inner classes.

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import scenic.study.thinkinjava.bruceeckel.util.AlphabeticComparator;

public class DirList2 {
    public static FilenameFilter
    filter(final String afn) {
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            String fn = afn;

            public boolean accept(File dir, String n) {
                // Strip path information:
                String f = new File(n).getName();
                return f.indexOf(fn) != -1;
            }
        }; // End of anonymous inner class
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(filter(args[0]));
        Arrays.sort(list,
                new AlphabeticComparator());
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
} ///:~