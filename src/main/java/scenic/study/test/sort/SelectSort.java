package scenic.study.test.sort;

import java.util.Arrays;

/*
 * 
 * ����˼�룺
��Ҫ�����һ�����У�ѡ����С��������󣩵�һ�������1��λ�õ���������
Ȼ����ʣ�µ�������������С��������󣩵����2��λ�õ���������
�������ƣ�ֱ����n-1��Ԫ�أ������ڶ��������͵�n��Ԫ�أ����һ�������Ƚ�Ϊֹ��
 * 
 */



public class SelectSort {

	public static void main(String args[]){
		
		int a[] = {4,1,5,7,2,3,9,6};  
	    System.out.println(Arrays.toString(a));
		f(a);
		System.out.println(Arrays.toString(a));
	}
	

	public static void f(int[] array){
		for(int i = 0; i < array.length; i++){
			int minIndex = i;
			int minValue = array[i];
			for(int j = i +1 ; j < array.length; j++){
				if(minValue > array[j]){
					minIndex = j;
					minValue = array[j];
				}
			}
			
			MyMath.swap(array, i, minIndex);
			
			
		}
		
	}
	
}
