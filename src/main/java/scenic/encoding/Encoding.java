package scenic.encoding;

import java.io.*;

/**
 * Created by liuzd2 on 2014/12/6.
 */
public class Encoding {
    static String fromPath = "D:\\eclipse_workspace\\ktouch\\Proxy_For_Net\\src\\";
   static String toPath = "D:\\eclipse_workspace\\study\\MyJavaUitl\\src\\scenic\\net\\proxy\\";
    public static void main(String args[]){




        File file = new File(fromPath);

        File[] files = file.listFiles();
        listFile(files);


    }

    public static void listFile(File[] files){
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if(file.isDirectory()){
                listFile(file.listFiles());
            }else{
                System.out.println(file.getAbsolutePath());
                if(file.getAbsolutePath().lastIndexOf(".java") != -1){
                    encoding(file,"gbk","utf-8");
                }
            }
        }
    }

    private static void encoding(File file,String charsetOrigin,String charsetTarget) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bread = null;
        try {
            bread = new BufferedReader(new InputStreamReader(new FileInputStream(file),charsetOrigin));
            String line;
            while((line = bread.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bread.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fout = null;

        try {
            byte[] bytes = sb.toString().getBytes();
            String newContent = new String(bytes,charsetTarget);
            String FilePath = file.getAbsolutePath().replace(fromPath,toPath) ;
            System.out.println(FilePath);
            File targetFile = new File(FilePath);
            fout = new FileOutputStream(targetFile);
            fout.write(newContent.getBytes());
            fout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fout != null){
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
