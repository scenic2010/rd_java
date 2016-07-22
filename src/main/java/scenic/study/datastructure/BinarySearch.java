package scenic.study.datastructure;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by scenic on 16/7/3.
 */
public class BinarySearch {
    public static int rank(int key, int[] dataArray) {

        int low = 0;
        int high = dataArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = dataArray[mid];

            if (key < midValue) {
                high = mid - 1;
            } else if (key > midValue) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int array[] = Utils.createTestArray();

        Utils.show(array);

        Arrays.sort(array);

        int key = array[3];
        System.out.println("key is " + key);
        System.out.println("rank is " + rank(key, array));
    }


}
