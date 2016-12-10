package scenic.study.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import scenic.MyLogger;

/**
 * Created by scenic on 2016/8/24.
 */
public class Main extends MyLogger.TestWithLogger{


    public static void main(String args[]){


    }

    @Test
    public void testGetClassAnnotation(){
        Annotation[] annotations =  TestAnnotation.class.getAnnotations();
        logger.debug("annotations length is " + annotations.length);
        for (Annotation a : annotations) {
            logger.debug(a);
        }
    }


    @Test
    public void testGetFieldAnnotation(){
        Field field = TestAnnotation.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Annotation[] annotations = field.getDeclaredAnnotations();
        logger.debug("type is " + field);
        showAnnotation(annotations);
    }

    @Test
    public void testGetParamAnnotation() throws NoSuchMethodException {
        Method method = TestAnnotation.class.getDeclaredMethod("testMethodWidthParam",String.class);
        method.setAccessible(true);
        Annotation[][] annotations = method.getParameterAnnotations();
        logger.debug("type is " + method);
        showAnnotation(annotations[0]);
    }


    private void showAnnotation(Annotation annotations[]) {
        if(annotations.length > 0){
            for (Annotation a :annotations) {
                logger.debug(a + " \t " + (a.annotationType().equals(FieldAnnotation.class)));

            }
        }else{
            logger.debug("length is 0");
        }
    }


    @AllTypeAnnotation("I am AllType")
    @ClassAnnotation("a class")
    public static class TestAnnotation {
        @AllTypeAnnotation("I am AllType")
        @FieldAnnotation("a Field")
        private String testField;

        @AllTypeAnnotation("I am AllType")
        public void testMethod1(){

        }

        public void testMethodWidthParam(@AllTypeAnnotation("I am AllType") @ParamAnnotation("a param") String param){

        }
    }

}
