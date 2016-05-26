package cunsum;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by scenic on 15/9/30.
 */
public class GenerateCarPlate {

    static  Random random = new Random();
    public static void main(String args[]) throws IOException {
//        for (int i = 0; i < locations.length; i++) {
//            String location = locations[i];
//            for (int j = 0; j < ch.length; j++) {
//                String chID = ch[j];
//                g1(location + chID + ".");
////
//            }
//
//        }




        Set<String> set = new HashSet<>();
        for (int i = 0; i < 200000; i++) {

            String dd = "京" +getRandChar() + "." ;//+ getRandOne() + getRandOne() + getRandOne() + getRandOne() + getRandOne() ;

            char[] chars = createCharArray();


            //任意选择两个位置插入字母
            int one = random.nextInt(6);
            int two = random.nextInt(6);

            if(one < chars.length){
                chars[one] = getRandChar();
            }

            if(two < chars.length){
                chars[two] = getRandChar();
            }

            //剩下的充填数字

            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == '='){
                    chars[j] = getRandNumber();
                }
            }

            set.add(dd + new String(chars));
            if(i % 10000 == 0){
                System.out.println(set.size());
            }
        }
//        Sy?\stem.out.println(set.size());

        Iterator<String> it = set.iterator();
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/scenic/carplate.txt"))));
            while (it.hasNext()){
                String tmp = it.next();
                bufferedWriter.write(tmp);
                bufferedWriter.newLine();
                System.out.println(tmp);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static char[] createCharArray() {
        char ch[] = new char[5];
        for (int i = 0; i < 5; i++) {
            ch[i] = '=';
        }
        return ch;
    }

    private static String getRandOne(){
        int size = random.nextInt(36);
        return allChar[size];
    }

    private static char getRandNumber(){
        int size = random.nextInt(10);
        return number[size];
    };

    private static char getRandChar(){
        int size = random.nextInt(26);
        return ch[size];
    }

    private static void g1(String locationAndID) {
        for (int i = 0; i < allChar.length; i++) {
            String value = allChar[i];
            g2(locationAndID + value);
        }

    }

    private static void g2(String s) {
        for (int i = 0; i < allChar.length; i++) {
            String value = allChar[i];
            g3(s + value);
        }
    }

    private static void g3(String s) {
        for (int i = 0; i < allChar.length; i++) {
            String value = allChar[i];
            g4(s + value);
        }
    }

    private static void g4(String s) {
        for (int i = 0; i < allChar.length; i++) {
            String value = allChar[i];
            g5(s + value);
        }
    }

    private static void g5(String s) {
        for (int i = 0; i < allChar.length; i++) {
            String value = allChar[i];
            p(s + value);
        }
    }

    static long number1111 = 0;

    private static void p(String s) {
        number1111++;

        if(number1111 % 100000000 == 0){
            System.out.println(number);
        }
    }


    static String allChar[] = {
            "A",
            "S",
            "D",
            "F",
            "G",
            "H",
            "J",
            "K",
            "L",
            "Q",
            "W",
            "E",
            "R",
            "T",
            "Y",
            "U",
            "I",
            "O",
            "P",
            "Z",
            "X",
            "C",
            "V",
            "B",
            "N",
            "M",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "0",
    };

    static char number[] = {
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            '0',
    };

    static char ch[] = new char[]{
            'A',
            'S',
            'D',
            'F',
            'G',
            'H',
            'J',
            'K',
            'L',
            'Q',
            'W',
            'E',
            'R',
            'T',
            'Y',
            'U',
            'I',
            'O',
            'P',
            'Z',
            'X',
            'C',
            'V',
            'B',
            'N',
            'M',
    };


    static String locations[] = {
            "京",
//            "冀",
//            "沪",
//            "申",
//            "沈",
//            "津",
//            "穗",
//            "汉",
//            "渝",
//            "蓉",
//            "榕",
//            "甬",
//            "邕",
//            "汴",
//            "皋",
//            "并",
//            "泽",
//            "洛",
//            "宛",
//            "濮",
//            "邺",
//            "亳",
//            "苏",
//            "杭",
//            "兖",
//            "淄",
//            "鹭",
//            "筑",
//            "鹏",
//            "禅",
//            "稿",
//            "潞",
//            "泽",
//            "宁",
//            "邕",
//            "肃",
//            "甘",
//            "越",

    };


}
