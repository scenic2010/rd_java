package scenic;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

/**
 * Created by scenic on 16/6/20.
 */
public class MyLogger {

    public static Logger get(Class claaz){
        String path = getPath();
        PropertyConfigurator.configure(path + "/src/main/java/log4j.properties");
        return Logger.getLogger(claaz);
    }

    private static String getPath() {
        String path = System.getProperty("user.dir");
        if(!path.contains("testjavalib")){
            path+="/testjavalib";
        }
        return path;
    }


    @Test
    public void test(){
        String path = getPath();
        System.out.println( path);
    }

    public static void main(String args[]){
        new MyLogger().test();
    }

}
