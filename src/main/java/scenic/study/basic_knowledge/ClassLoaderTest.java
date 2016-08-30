package scenic.study.basic_knowledge;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import scenic.MyLogger;

/**
 * Created by scenic on 2016/8/26.
 */
public class ClassLoaderTest extends MyLogger.TestWithLogger{

    @Test
    public void testBegin(){

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
           logger.debug(urls[i].toExternalForm());
        }

    }

    @Test
    public void testTest(){

        try {
            /*ClassLoader loader = ClassLoaderTest.class.getClassLoader();  //获得ClassLoaderTest这个类的类加载器
            while(loader != null) {
                System.out.println(loader);
                loader = loader.getParent();    //获得父加载器的引用
            }
            System.out.println(loader);*/

            String rootUrl = "http://localhost:8080/rd/classes/scenic";
            NetworkClassLoader networkClassLoader = new NetworkClassLoader(rootUrl);
            String classname = "scenic.study.basic_knowledge.ClassLoaderTest";
            Class clazz = networkClassLoader.loadClass(classname);
            logger.debug(clazz.newInstance());
            System.out.println(clazz.getClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetWebClass(){
        try {
            //测试加载网络中的class文件
            String rootUrl = "http://localhost:8080/httpweb/classes";
            String className = "org.classloader.simple.NetClassLoaderSimple";
            NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
            NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
            Class<?> clazz1 = ncl1.loadClass(className);
            Class<?> clazz2 = ncl2.loadClass(className);
            Object obj1 = clazz1.newInstance();
            Object obj2 = clazz2.newInstance();
            clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    /**
     * 加载网络class的ClassLoader
     */
    public static class NetworkClassLoader extends ClassLoader {

        private String rootUrl;

        public NetworkClassLoader(String rootUrl) {
            this.rootUrl = rootUrl;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            //this.findLoadedClass(name); // 父类已加载
            Class clazz;
            //if (clazz == null) {  //检查该类是否已被加载过
            //根据类的二进制名称,获得该class文件的字节码数组
            byte[] classData = getClassData(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            }
            //将class的字节码数组转换成Class类的实例
            clazz = defineClass(name, classData, 0, classData.length);
            //}
            return clazz;
        }

        private byte[] getClassData(String name) {
            InputStream inputStream = null;
            try {
                String path = classNameToPath(name);
                URL url = new URL(path);
                byte[] buff = new byte[1024*4];
                int len;
                inputStream = url.openStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while((len = inputStream.read(buff)) != -1) {
                    byteArrayOutputStream.write(buff,0,len);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        private String classNameToPath(String name) {
            return rootUrl + "/" + name.replace(".", "/") + ".class";
        }

    }
}
