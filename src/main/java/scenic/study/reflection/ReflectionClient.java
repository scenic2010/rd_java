package scenic.study.reflection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import scenic.MyLogger;

/**
 * Created by scenic on 16/7/21.
 */
public class ReflectionClient {

    private static Logger logger = MyLogger.get(ReflectionClient.class);

    public static void main(String args) throws ClassNotFoundException {

        Class.forName(Demo1.class.getName());
    }


    @Test
    public void testClassForName() throws ClassNotFoundException {
        String classGetName = Demo1.class.getName();
        logger.info(classGetName);
    }

    @Test
    public void testClassLoadType() throws ClassNotFoundException {
        Class<Demo1> class1 = Demo1.class;
        Class class2 =  Class.forName("scenic.study.reflection.ReflectionClient$Demo1");

        logger.info(class1);
        logger.info(class1 == class2);

    }

    @Test
    public void testParentClass(){
        Class class2 = Demo2.class;
        Class class3 = Demo3.class;
        logger.info(class2);
        logger.info(class3);
        logger.info(class3.getSuperclass());

        logger.info(class2 == class3);
        logger.info(class2 == class3.getSuperclass());
    }



    @Test
    public void testCreateDemo1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> object = Demo1.class;
        Demo1 demo1 = (Demo1) object.newInstance();
        logger.info("demo1 " + demo1);
    }

    @Test
    public void testCreateDemo2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> object = Demo2.class;
        Constructor constructor = object.getConstructor(int.class);
        constructor.setAccessible(true);
        Demo2 demo2 = (Demo2) constructor.newInstance(2);
        logger.info(demo2);
    }




    static class Demo1 {

    }

    private static class Demo2 {
        public int a;
        public Demo2(int a){
            this.a = a;
        }
    }

    public static class Demo3 extends Demo2 {

        public Demo3(int a) {
            super(a);
        }
    }

}
