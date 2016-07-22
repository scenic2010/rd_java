package scenic.study.self_test;

import org.junit.Test;

/**
 * Created by scenic on 16/7/21.
 */
public class TestString {


    @Test
    public void testRegionMatches(){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.ensureCapacity(32);
        System.out.println("capacity " + stringBuffer.capacity());

        stringBuffer.setLength(10);
        System.out.println("length " + stringBuffer.length());

         int byvalue;

    }


    @Test
    public void testStringMethod(){
        String string = new String("hello");
        modifyString(string);
        System.out.println("string is " + string);
    }

    private void modifyString(String str){

        str = null;
    }



    @Test
    public void testString(){
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        String str5 = str3.intern();
        String str6 = new String("hello").intern();


        System.out.println("str1==str2 " + (str1 == str2));
        System.out.println("str1==str5 " + (str1 == str5));
        System.out.println("str5==str6 " + (str5 == str6));

    }


}
