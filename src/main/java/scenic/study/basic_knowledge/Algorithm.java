package scenic.study.basic_knowledge;

import org.junit.Test;

import java.util.List;

/**
 * Created by scenic on 2016/11/15.
 * 测试算法
 */

public class Algorithm {

    List list = null;

    public static void showArray (int[] array){
        if(array == null){
            System.out.println("null");
            return;
        }
        for (int a : array
             ) {
            System.out.print(a + "\t");
        }

    }



    public static class TestArray {

        /*

        Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].



         */
        @Test
        public void test(){
            int[] array = {2,7,11,15};
            showArray(twoSum(array,9));


            System.out.println();
            array = new int[]{3,2,4,15};
            showArray(twoSum(array,6));

            System.out.println();
            array = new int[]{-1,-2,-3,-4,-5};
            showArray(twoSum(array,-8));


        }

        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for(int i = 0; i < nums.length ; i++){
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return null;
        }
    }
}
