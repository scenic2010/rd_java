package scenic.study.test.sort;

import java.util.HashMap;

public class TestHashMap {

	static HashMap<Integer,String> map = new HashMap<Integer,String>();
	public static void main(String args[]){
		
		
		
		System.out.println( map.put(1, "a"));
		
		System.out.println(  map.put(2, "b"));
		System.out.println( map.put(1, "c"));
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		
		
		
		Object value = new Insert();
		System.out.println( value.hashCode() + " 	" + (32 & hash(value)));
	}
	
//	static int hash(int h) {  
//	    h ^= (h >>> 20) ^ (h >>> 12);  
//	    return h ^ (h >>> 7) ^ (h >>> 4);  
//	}  
	
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
}
