package scenic.study.arithmetic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scenic on 2016/12/9.
 */

public class Array {
    /**
     * 给定一个整形的数组，找出其中的两个数，使其和为某个指定的数值。要求时间复杂度O（n）
     */
    public static class TowSum {
        //两数之和2
        @Test
        public void test() {
            int[] test1 = {4, 6, 8, 9, 2, 1, 9, 0};
            int result[] = twoSum(test1, 6);
            System.out.println(Arrays.asList(result[0],result[1]));

            test1 = new int[]{1,4,3,7,4,3,7,8};
            result = twoSumAdvance(test1,6);
            System.out.println(Arrays.asList(result[0],result[1]));

        }

        //进军硅谷 page 62
        // 假定数组元素各不相同
        public int[] twoSum(int[] array, int target) {
            int result[] = {-1, -1};

            Map<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                hashMap.put(array[i], i);
            }
            //O(n)

            for (int i = 0; i < array.length; i++) {
                int value = array[i];
                int distance = target - value;
                if (target != 2 * value // 没有相同的数
                        &&
                        hashMap.containsKey(distance)) {
                    result[0] = i;
                    result[1] = hashMap.get(distance);
                    break;
                }
            }
            return result;
        }


        class Entity {
            //出现的次数
            int sequence;
            List<Integer> indexArray = new ArrayList<>();

            public Entity plus() {
                sequence++;
                return this;
            }

            public Entity saveIndex(int index) {
                indexArray.add(index);
                return this;
            }

            public int getSequence() {
                return sequence;
            }

            public List<Integer> getIndexArray() {
                return indexArray;
            }
        }

        //数组元素有可能相同,page 63
        //如果可能出现相同的元素，可以使用map记录出现的次数和数组的坐标
        public int[] twoSumAdvance(int[] array, int target) {
            int result[] = {-1, -1};

            Map<Integer, Entity> map = new HashMap<>();

            for (int i = 0; i < array.length; i++) {
                int value = array[i];
                if (map.get(value) == null) {
                    map.put(value, new Entity().plus().saveIndex(i));
                } else {
                    map.get(value).plus().saveIndex(i);
                }
            }

            for (int i = 0; i < array.length; i++) {
                int value = array[i];
                int distance = target - value;

                Entity entity = map.get(distance);
                if (entity != null) {
                    if (entity.getSequence() > 1) {
                        result[0] = entity.getIndexArray().get(0);
                        result[1] = entity.getIndexArray().get(1);
                        break;
                    } else {
                        result[0] = i;
                        result[1] = entity.getIndexArray().get(0);
                        break;
                    }
                }
            }


            return result;
        }

    }
}
