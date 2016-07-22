package scenic.study.datastructure;

import java.util.Random;

/**
 * Created by scenic on 16/7/3.
 */
public class Utils {

    public static int[] createTestArray(){
        int[] list = new int[10];
        Random random = new Random();
        for(int i =0; i < list.length ; i++){
            list[i] = (random.nextInt(100));
        }
        return list;
    }

    public static void show(int array[]){
        for (int v :
                array) {
            System.out.println(v
            );
        }
    }
}
