//: DirList.java
// Displays directory listing
package scenic.study.thinkinjava.io.self;

import org.apache.log4j.Logger;

import java.io.*;

import scenic.MyLogger;

public class DirList {

    static Logger logger = MyLogger.get(DirFilter.class);

    public static void main(String[] args) {
        String fileValue = "gra";
        try {
            File path = new File(".");
            String[] list;

            if (fileValue == null){
                list = path.list();
            }else {
                list = path.list(new DirFilter(fileValue));
            }

            for (int i = 0; i < list.length; i++){
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class DirFilter implements  FilenameFilter {

        private String filter;
        public DirFilter(String filter){
            this.filter = filter;
        }

        @Override
        public boolean accept(File dir, String name) {
            logger.info("dir " + dir + "  name " + name );
            if(name.contains(filter)){
                return true;
            }
            return false;
        }
    }
}