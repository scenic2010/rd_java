package scenic.study.test.sort;

import java.util.Arrays;

public class Insert {

	public static void main(String[] args) {
		int a[] = {3,1,5,7,2,4,9,6};  
	    System.out.println(Arrays.toString(a));
	    
		insertSort(a);
		
	}

	private static void insertSort(int[] array) {
		
		for(int i = 1; i < array.length; i++){
			int tmp = -1;
			int j = -1;
			if(array[i] < array[i-1]){				
				j = i - 1;
				tmp = array[i];
				array[i] = array[i-1];
				while(j >=0 && tmp < array[j]){
					array[j+1] = array[j];
					j--;
				}
				array[j + 1] = tmp;
			}
			
			System.out.println(Arrays.toString(array)+"\t" + tmp + "\t" + j);
		}		
	}

}
