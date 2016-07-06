package scenic.study.thinkinjava.container;//: c09:AlphabeticSearch.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Searching with a Comparator.

import java.util.Arrays;

import scenic.study.thinkinjava.bruceeckel.util.AlphabeticComparator;
import scenic.study.thinkinjava.bruceeckel.util.Arrays2;

public class AlphabeticSearch {
  public static void main(String[] args) {
    String[] sa = new String[30];
    Arrays2.fill(sa,
      new Arrays2.RandStringGenerator(5));
    AlphabeticComparator comp =
      new AlphabeticComparator();
    Arrays.sort(sa, comp);
    int index =
      Arrays.binarySearch(sa, sa[10], comp);
    System.out.println("Index = " + index);
  }
} ///:~