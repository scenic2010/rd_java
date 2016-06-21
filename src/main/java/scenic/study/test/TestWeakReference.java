package scenic.study.test;

import java.lang.ref.WeakReference;

public class TestWeakReference {
	/**  
     * @param args  
     */  
    public static void main(String[] args) {   
        MyEclipseGen a = new MyEclipseGen();
        a.str = "Hello, reference";   
        WeakReference<MyEclipseGen> weak = new WeakReference<MyEclipseGen>(a);
        a = null;   
        int i = 0;   
        while (weak.get() != null) {   
            System.out.println(String.format("Get str from object of WeakReference: %s, number1: %d", weak.get().str, ++i));
            if (i % 10 == 0) {   
                System.gc();   
                System.out.println("System.gc() was invoked!");   
            }   
            try {   
                Thread.sleep(500);   
            } catch (InterruptedException e) {   
  
            }   
        }   
        System.out.println("object a was cleared by JVM!");   
    }   
  
}  
