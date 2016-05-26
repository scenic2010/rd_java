package scenic.study.test;

public class BinarySearch {

	public static void main(String args[]){
		int a[] = {1,2,3,4,5,6,7,9};  
		System.out.println( binSearch(a, 0, a.length - 1, 7));
		
	}
	
	
	
	public static int binSearch(int[] array,int min,int max,int key){
		
		
		//�ݹ�
//		if(max >= min){
//			int midIndex = (min + max) / 2;
//			
//			if(key == array[midIndex]){
//				return midIndex;
//			}else if(key > array[midIndex]){
//				return binSearch(array, midIndex +1, max, key);
//			}else if(key < array[midIndex]){
//				return binSearch(array,min,midIndex -1,key);
//			}else {
//				System.out.println("Error " + min + "  " + max);
//				return -1;
//			}
//		}else {
//			return -1;
//		}
		
		
		
		
		//���ݹ�
		while(max >= min){
			int midIndex = (min + max) / 2;
			if(array[midIndex] == key){
				return midIndex;
			}else if(array[midIndex] > key) {
				
				max = midIndex -1;
			}else if(array[midIndex] < key){
				min = midIndex + 1;
			}
		}
			
		return -1;
		
	}
	
}
