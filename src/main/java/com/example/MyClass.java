package com.example;

import java.io.File;

public class MyClass {
    public static void main(String args[]){

        String str = "超正妹子拿高中课本一起拍验证+广发银行极品美女职员吴薇,超大奶美女,粤语+超正妹子拿高中课本一起拍验证+广发银行极品美女职员吴薇,超大奶美女,粤语+人白穴嫩奶粉的90后连续高潮56次+偷拍宿舍的哥们干女友+学校厕所做爱+天津华新街仙艺美甲女教师自拍+台湾女孩陈焉灵宾馆爱爱自拍+邻家姐姐老公出差去安慰下+极品妹妹千露露的诱惑自拍+东森会所800包宿个小领舞";
//       String vale =  new MyClass().getSortFileName("
// ");
//
//        System.out.printf("value is " + vale);

        System.out.println(
                new MyClass().verifiedFileLength(new File("/sdcard/mmmm/dfafafadf/afadfa/ffff" + str + str + str)).getAbsolutePath()

        );


    }


    /**
     *
     * @param origin
     * @return
     */
    private File verifiedFileLength(File origin){
        if(origin == null){
            return null;
        }
        String absolutePath = origin.getAbsolutePath();
        System.out.printf("absolutePath " + absolutePath);
        int charSize = calcTheStringCharSize(absolutePath);

        System.out.printf("the all size is " + charSize);

        int TOTAL_SIZE = 255;
        if(charSize < TOTAL_SIZE){
            //绝对字符的长度小于255的话,可以使用原来的
            return origin;
        }



        //按照最后一个反斜杠 把绝对路径分割成两部分,把最后一部分切割计算hashcode
        int lastIndex = absolutePath.lastIndexOf("/")+1;
        String firstPath = absolutePath.substring(0,lastIndex);
        String lastPath = absolutePath.substring(lastIndex);
        System.out.println("fist path is " + firstPath);
        System.out.println("last path is " + lastPath);


        if(firstPath.length() >= TOTAL_SIZE){
            //如果路径超过了限制,直接抛出异常
            throw new RuntimeException("the file path is too long");
        }

        try{
            int loopSize = 0;
            while (true){
                loopSize++;
                //把最后一部分对半截取
                int lastPathLength = lastPath.length() / 2;
                String lastFirst = lastPath.substring(0, lastPathLength);
                String lastLastString = lastPath.substring(lastPathLength);
                System.out.println("first path of last-path is " + lastFirst);
                System.out.println("last path of last-path is " + lastLastString);
                lastPath = lastFirst + hashCode(lastLastString);
                System.out.printf("the last path in do is " + lastPath);
                String tmpAbsolutePath = firstPath + lastPath;
                if(calcTheStringCharSize(tmpAbsolutePath) < TOTAL_SIZE){
                    return new File(tmpAbsolutePath);
                }
                if(loopSize > 50){
                    //容错处理
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new File(firstPath + hashCode(lastPath));
    }



    private int calcTheStringCharSize(String absolutePath) {
        //取出所有中文的字符串
        StringBuilder chineseChar = new StringBuilder();
        StringBuilder englishChar = new StringBuilder();
        for (int i = 0; i < absolutePath.length(); i++) {
            String chartmp = String.valueOf(absolutePath.charAt(i));
            if(chartmp.matches("[\\u4e00-\\u9fa5]")){
                chineseChar.append(chartmp);
            }else {
                englishChar.append(chartmp);
            }
        }

        System.out.println("the chinese string is " + chineseChar.toString() + "  length is" + chineseChar.length());
        System.out.println("the english string is " + englishChar.toString() + "  length is" + englishChar.length());

        return 2*chineseChar.length() + englishChar.length();
    }


    private String getSortFileName(String longFileName){
        final int MAX_LENGTH = 127;
        final int SPLIT_INDEX = 100;

        if(longFileName.length() < MAX_LENGTH){
            return longFileName;
        }

        String firstPart = longFileName.substring(0,SPLIT_INDEX);
        String lastPart = longFileName.substring(SPLIT_INDEX);

        System.out.println("firstPart " + firstPart);
        System.out.println("lastPart " + lastPart );

        String returnValue = firstPart + hashCode(lastPart);
        System.out.println("the result value length is " + returnValue.length());
        return returnValue;
    };

    public static String hashCode(String url) {
        int res = url.hashCode();
        if (res > 0) {
            return String.valueOf(res);
        } else {
            long result = 0;
            result = (long) (res >>> 24 & 0xff) << 24;
            result |= (long) (res >>> 16 & 0xff) << 16;
            result |= (long) (res >>> 8 & 0xff) << 8;
            result |= (long) (res & 0xff);
            return String.valueOf(result);
        }
    }
}
