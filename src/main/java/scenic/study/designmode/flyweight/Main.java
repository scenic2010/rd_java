package scenic.study.designmode.flyweight;

import org.junit.Test;

public class Main {

	/**
	 * 享元模式
	 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
	 * 如果一个应用使用了大量的对象，而这些大量的对象造成了很大的内存开销的时候，应该考虑享元模式；
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testString(){
		String a = "你好";
		String b = "你好";
		//此处打印是一样的，应为使用了享元模式
		System.out.println(a.equals(b));
	}

}
