package scenic.collections;

import org.junit.Test;

/**
 * Created by scenic on 16/6/8.
 */
public class TestString {



    @Test
    public void testStringSubtraction(){
        System.out.println("====testStringSubtraction====");

        String allString = "com.scenic.rd_android.ui.activity";
        String subString = "com.scenic.rd_android";

        System.out.println("allString is " + allString);
        System.out.println("subString is " + subString);


        int subStringLength = subString.length();
        System.out.println("subString length is " + subStringLength);
        System.out.println("allString subtraction subString is " + allString.substring(subString.length()));

        System.out.println();
    }

    @Test
    public void testStringLastIndexOf(){

        System.out.println("====testStringLastIndexOf====");

        String allString = "com.scenic.rd_android.ui.activity";
        String subString = "com.scenic.rd_android";
        String subtractionString = allString.substring(subString.length());

        System.out.println("allString is " + allString);
        System.out.println("subString is " + subString);
        System.out.println("separator is . ");
        System.out.println("subtractionString is " + subtractionString);

        System.out.println("subtractionString.indexOf('.') is " + subtractionString.indexOf('.'));

        int subtractionStringIndexOf = subtractionString.indexOf('.',1);
        System.out.println("int subtractionStringIndexOf = subtractionString.indexOf('.',1) ,subtractionStringIndexOf is " + subtractionStringIndexOf);

        System.out.println("subtractionString.charAt(subtractionStringIndexOf) is " + subtractionString.charAt(subtractionStringIndexOf));

        System.out.println("subtractionString.substring(subtractionStringIndexOf) is " + subtractionString.substring(subtractionStringIndexOf));
        System.out.println("subtractionString.substring(0,subtractionStringIndexOf) is " + subtractionString.substring(0,subtractionStringIndexOf));


        System.out.println();

    }
}
