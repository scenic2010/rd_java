package scenic.study.arithmetic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scenic on 2016/12/9.
 */

public class Array {
    public static class TowSum {
        //两数之和2
        @Test
        public void test() {
            int[] test1 = {4, 6, 8, 9, 2, 1, 9, 0};
            int result[] = twoSum(test1, 6);
            for (int a :
                    result) {
                System.out.println(a);
            }
        }
        //进军硅谷 page 62
        public int[] twoSum(int[] array, int target) {
            int result[] = {-1, -1};

            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                hashMap.put(array[i], i);
            }

            for (int i = 0; i < array.length; i++) {
                int value = array[i];
                if (target != 2 * value && hashMap.containsKey(target - value)) {
                    result[0] = i;
                    result[1] = hashMap.get(target - array[i]);
                    break;
                }
            }
            return result;
        }
    }
}
