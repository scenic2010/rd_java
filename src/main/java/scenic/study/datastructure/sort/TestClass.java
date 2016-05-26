package scenic.study.datastructure.sort;

/**
 * Created by scenic on 4/21/15.
 */
public class TestClass {


    public static void main(String args[]){
        String A = "Marginle" , B = "Valaienie";
        char ch[] = A.toCharArray();
        quicksort(ch,0,A.length() - 1);
        str_in_common(ch,ch.length,B.toCharArray());
    }

    /**
     * description : 快速排序
     * @autor kwzhang
     * modify :2012-6-20

     * @param left
     * @param right
     * @return
     */
    static void quicksort(char n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(char n[], int left, int right) {
        char pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }



    public static int search(char[] arr, char key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    static  String str_in_common(char[] s1,int len,char[] s2){
        int i = 0;
        char[] p;
        p = s2;

        char[] result = new char[s1.length];
        for(int index = 0; index < p.length; index++ ){
            if(search(s1,p[i]) == 1)//查找相同字符
            result[i++] = p[i];
        }
        result[i] = '\0';
        return result.toString();
    }

}
