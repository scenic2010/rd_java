package scenic.study.thinkinjava.io;//: c11:TestEOF.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Testing for the end of file 
// while reading a byte at a time.

import java.io.*;

public class TestEOF {
    // Throw exceptions to console:
    public static void main(String[] args)
            throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("testjavalib/src/main/java/scenic/study/thinkinjava/io/TestEOF.java")));
        while (in.available() != 0)
            System.out.print((char) in.readByte());
    }
} ///:~