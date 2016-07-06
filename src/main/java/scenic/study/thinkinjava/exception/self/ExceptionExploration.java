package scenic.study.thinkinjava.exception.self;

import org.junit.Test;

/**
 * Created by scenic on 16/7/6.
 *
 * RuntimeException 代表一个编程的错误,没有必要单独的去捕获
 *
 */
public class ExceptionExploration {
    public static void main(String args[]){

        Exception e;
        RuntimeException runtimeException;

    }

    @Test
    public void testException() {

        try {
            throw new Exception("test exception");
        } catch (Exception e) {
//            e.printStackTrace();
            e.printStackTrace();
        }
    }

    @Test
    public void testRunTimeException() {

        throw new RuntimeException("test runtime exception");
    }

}
