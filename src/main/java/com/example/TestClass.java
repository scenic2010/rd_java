package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scenic on 15/9/10.
 */
public class TestClass {

    public static void main(String [] args){
        String value = "QUFtYWduZXQ6P3h0PXVybjpidGloOjQ5YmI1ZDU5MTJkM2RjNWRjYmZmMzkzZTNiZTYzMzZiMGExZGE5M2JaWg==";
        new TestClass().checkTheBase64(value);
    }

    private void checkTheBase64(String base64Value) {

        Pattern p = Pattern.compile("([A-Za-z0-9\\+/=]+)([^A-Za-z0-9\\+/=]?)");
        Matcher m = p.matcher(base64Value);
        if(m.matches()){
            System.out.println("matches");
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println("g1 " + g1);
            System.out.println("g2 " + g2 == null || g2.equals(""));

        }else {
            System.out.printf("not matches");
        }
    }
}
