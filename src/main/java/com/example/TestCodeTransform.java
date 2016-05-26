package com.example;

import java.io.UnsupportedEncodingException;

/**
 * Created by scenic on 15/8/29.
 */
public class TestCodeTransform {
    public static void main(String args[]) throws UnsupportedEncodingException {
        TestCodeTransform transform = new TestCodeTransform();
        String testString = "fadfaga爱疯十多个";


        String test2 = transform.enCoding(testString,"gbk");

        transform.printEncoding(test2);
    }

    public void printEncoding(String str ) throws UnsupportedEncodingException {
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(changeCharset(str,"gbk","utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str,"utf-8"));
        System.out.println(enCoding(str, "utf-8"));
    }


    public String enCoding(String original,String codeFormat){
        byte[] bytes = original.getBytes();
        try {
            return new String(bytes,codeFormat);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.printf("Error not encoding");
        return original;
    }

    /**
     * 字符串编码转换的实现方法
     *
     * @param str
     *            待转换编码的字符串
     * @param oldCharset
     *            原编码
     * @param newCharset
     *            目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public String changeCharset(String str, String oldCharset, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            // 用旧的字符编码解码字符串。解码可能会出现异常。
            byte[] bs = str.getBytes(oldCharset);
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }

        return null;
    }
}
