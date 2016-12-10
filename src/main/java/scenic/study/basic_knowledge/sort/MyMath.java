package scenic.study.basic_knowledge.sort;

import org.junit.Test;

public class MyMath {

	public static void swap(int[] array,int indexa, int indexb){
		
		int tmp = array[indexa];
		
		array[indexa] = array[indexb];
		
		array[indexb] = tmp;
		
	}


	@Test
	public void testArray() {



	}

}
