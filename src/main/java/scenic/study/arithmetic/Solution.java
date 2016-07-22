package scenic.study.arithmetic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    public static void main(String args[]) {

//        int[] number = {1,1,-2};
//        int[] number = {1, 1, 1};
//        int[] number = {0,0,0};
        int[] number = {-1, 0, 1, 2, -1, -4};



    }


    @Test
    public void testThreeSum1(){
        int[][] testValue = {
                {-1, 0, 1, 2, -1, -4},
                {0, 0, 0},
                {1, 1, 1},
                {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}
        };

        for (int[] v :
                testValue) {
            System.out.println(threeSum1(v));
        }

    }


    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int firstLast = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            if (firstLast == n1) {
                continue;
            } else {
                firstLast = n1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];
                int tmp = n1 + n2;
                int index, low = j + 1, height = nums.length;


                if ((index = Arrays.binarySearch(nums, low, height, -tmp)) > 0) {
                    result.add(Arrays.asList(n1, n2, nums[index]));
                }
            }
        }

        for (List<Integer> l : result) {
            list.add(l);
        }
        return list;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> lowZero = new ArrayList<>();
        List<Integer> heightZero = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                heightZero.add(nums[i]);
            } else {
                lowZero.add(nums[i]);
            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < lowZero.size(); i++) {
            int lowValue = lowZero.get(i);

            for (int j = 0; j < heightZero.size(); j++) {
                int hv1 = heightZero.get(j);

                for (int h = j + 1; h < heightZero.size(); h++) {
                    int hv2 = heightZero.get(h);
                    if (-lowValue == (hv1 + hv2)) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(lowValue);
                        tmp.add(hv1);
                        tmp.add(hv2);
                        result.add(tmp);
                    }
                }
            }
        }


        for (int i = 0; i < heightZero.size(); i++) {
            int hValue = heightZero.get(i);

            for (int j = 0; j < lowZero.size(); j++) {
                int lv1 = lowZero.get(j);

                for (int h = j + 1; h < lowZero.size(); h++) {
                    int lv2 = lowZero.get(h);

                    if (-hValue == (lv1 + lv2)) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(hValue);
                        tmp.add(lv1);
                        tmp.add(lv2);
                        result.add(tmp);
                    }
                }
            }
        }


        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : result) {
            list.add(l);
        }

        return list;
    }
}