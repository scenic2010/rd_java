package scenic.study.java8lambda;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by scenic on 16/7/25.
 */
public class TestLambda {

    @Test
    public void test1(){
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

            }
        };

        Runnable runnable = () -> {

        };

        Runnable runnable1 = ()->{};


        dddd t = () -> {
        };

    }

    interface  dddd {
        void dd();
    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

        }
    });



    Observer observer1 = (Observable o,Object arg)->{
        System.out.println(o);
    };

    public int add(int x, int y){
        return x+y;
    }


}
