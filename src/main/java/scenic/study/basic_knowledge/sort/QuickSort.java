package scenic.study.basic_knowledge.sort;

import java.util.Arrays;

public class QuickSort {

	/*
	 * 
	 * ����˼�룺
1��ѡ��һ����׼Ԫ�� ��ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ�أ�
2��ͨ��һ������Ѵ�����ļ�¼�ָ�ɶ����������֣�����һ���ּ�¼��Ԫ��ֵ���Ȼ�׼Ԫ��ֵС����һ���ּ�¼�� Ԫ��ֵ�Ȼ�׼ֵ��
3����ʱ��׼Ԫ�������ź�������ȷλ��
4��Ȼ��ֱ���������ּ�¼��ͬ���ķ���������������ֱ��������������

	 * 
	 */
	
	public static void main(String[] args) {
		int a[] = {4,1,5,7,2,3,9,6};  
	    System.out.println(Arrays.toString(a));
	    
		sort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

	
	private static void sort(int[] array,int low,int high){
		System.out.println(low + "  " + high);
		if(low < high){
			int privotKey = partition(array, low, high);
			
			sort(array, low,privotKey -1);
			sort(array, privotKey +1,high);
		}
	}
	
	
	private static int partition(int[] array,int lowIndex,int highIndex) {
		int privotKey = array[lowIndex];
		while(highIndex > lowIndex){
			while(highIndex > lowIndex && array[highIndex] >= privotKey){
				highIndex--;
			} 
			//��С��ê��ķ��� lowIndex��һ��
			swap(lowIndex,highIndex,array);
			
			while(highIndex > lowIndex && array[lowIndex] <= privotKey) {
				lowIndex++;	
			}
			//�Ѵ���ê��ķ���hightIndex��һ��
			swap(lowIndex,highIndex,array);
			
		}
		
		return lowIndex;
		
	}

	private static void swap(int low, int high, int[] array) {
		int tmp = array[high];
		array[high] = array[low];
		array[low] = tmp;
	}

}
