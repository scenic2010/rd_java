package scenic.study.basic_knowledge.sort;

public class MyMath {

	public static void swap(int[] array,int indexa, int indexb){
		
		int tmp = array[indexa];
		
		array[indexa] = array[indexb];
		
		array[indexb] = tmp;
		
	}
}