package scenic.study.designmode.strategy.strategy_1;

import java.lang.*;

/**
 * Created by liuzd2 on 2014/11/23.
 * 冒择路（入）兮（希尔）快归堆
 */
public class DataSort {
    public static void sort(Comparable[] a){
        //冒泡
        for (int i = a.length; i > 0; i--){
            for (int j = 0;  j< i-1 ; j++) {
                Comparable c1 =(Comparable) a[j];
                Comparable c2 =(Comparable) a[j+1];
                if (c1.compareTo(c2) > 0){
                    swap(a,j,j+1);
                }
            }
        }
    }
    public static void sort(int[] a){
        //冒泡
        for (int i = a.length; i > 0; i--){
            for (int j = 0;  j< i-1 ; j++) {
                if (a[j] > a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
//    public static void sort(Cat[] a){
//        //冒泡
//        for (int i = a.length; i > 0; i--){
//            for (int j = 0;  j< i-1 ; j++) {
//                if (a[j].getHeight() > a[j+1].getHeight()){
//                    swap(a,j,j+1);
//                }
//            }
//        }
//    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void p(int []a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(" " +a[i]);
        }
    }

    public static void p(Cat[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.println(" " +a[i]);
        }
    }
}
