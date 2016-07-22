package scenic.study.thinkinjava.io.self;

/**
 * test
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.zip.GZIPOutputStream;

/**
 * Created by scenic on 16/7/7.
 */
public class ScenicIOTest {

    public static final String rootPath = "src/main/java/scenic/study/thinkinjava/io";
    public static final String rootMain = "testjavalib/src/main/java/scenic/study/thinkinjava/io";

    File testFile;
    File testOut;
    FileInputStream inputStream;
    PrintStream printStream;

    @Test
    public void testGZIP(){
        try {
            GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream(new File(rootPath+"/self","scenic_test.zip")));
            PrintWriter writer =  new PrintWriter(new OutputStreamWriter(outputStream));
            writer.println("测试");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriter(){
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("sdfsdf");
        printWriter.flush();
        printWriter.close();
    }

    @Test
    public void testReader(){

    }

    @Test
    public void testStringBufferInputStream() {
        StringReader stringReader = new StringReader("hello , i am a good student");
        StreamTokenizer streamTokenizer = new StreamTokenizer(stringReader);
        showStreamTokenizer(streamTokenizer);
    }

    @Test
    public void testStreamTokenizer() {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(inputStream));
        streamTokenizer.ordinaryChar('.');
        streamTokenizer.ordinaryChar('-');
//        streamTokenizer.ordinaryChar('s');
//        streamTokenizer.ordinaryChar('*');
//        streamTokenizer.commentChar(';');
//        streamTokenizer.quoteChar(';');
        showStreamTokenizer(streamTokenizer);

    }


    @Before
    public void beFore() {
        testFile = new File(rootPath + "/self/ScenicIOTest.java");
        try {
            inputStream = new FileInputStream(testFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not find " + testFile.getAbsolutePath());
        }

        testOut = new File(rootPath + "/self/TestOut.txt");

        try {
            printStream = new PrintStream(testOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not find " + testOut.getAbsolutePath());
        }


    }

    @After
    public void after() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (printStream != null) {
            printStream.close();
        }
    }

    @Test
    public void testAvailable() throws IOException {
        System.out.println(inputStream.available());
        do {
//            System.out.println();
            System.out.print((char) inputStream.read());
        } while (inputStream.available() != 0);

    }

    @Test
    public void testPrintStream() {
        printStream.println("my test");
    }


    @Test
    public void testRandomAccessFile() {
        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile(testOut, "rw");
//            for (int i = 0; i < 10; i++)
//                randomAccessFile.writeDouble(i * 1.414);
//            randomAccessFile.close();


            RandomAccessFile randomAccessFile = new RandomAccessFile(testOut, "r");

            randomAccessFile.seek(40);
            System.out.println(randomAccessFile.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showStreamTokenizer(StreamTokenizer streamTokenizer) {
        try {
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                String s;
                switch (streamTokenizer.ttype) {
                    case StreamTokenizer.TT_EOL:
                        s = "TT_EOL\t" + new String("EOL");
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        s = "TT_number\t" + Double.toString(streamTokenizer.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = "TT_Word\t" + streamTokenizer.sval; // Already a String
                        break;
                    default: // single character in ttype
                        s = "Default\t" + String.valueOf((char) streamTokenizer.ttype);
                }
                System.out.println(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
