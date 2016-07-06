package scenic.study.thinkinjava.container;//: c09:AlphabeticSorting.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Keeping upper and lowercase letters together.

import java.util.Arrays;

import scenic.study.thinkinjava.bruceeckel.util.AlphabeticComparator;
import scenic.study.thinkinjava.bruceeckel.util.Arrays2;

public class AlphabeticSorting {
  public static void main(String[] args) {
    String[] sa = new String[30];
    Arrays2.fill(sa,
      new Arrays2.RandStringGenerator(5));
    Arrays2.print("Before sorting: ", sa);
    Arrays.sort(sa, new AlphabeticComparator());
    Arrays2.print("After sorting: ", sa);
  }
} ///:~