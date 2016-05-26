package scenic.study.designmode.composite;

import org.junit.Test;
/**
 * 组合模式
 * 部分和整体的关系，一般将对象组合成树形的结构表示部分和整体的层次关系
 * 
 * @param args
 */
public class Main {

	
	public static void main(String[] args) {
		
	}


	
	
	
	@Test
	public void testNote(){
		//测试树状展现
		Note root = new Note("root");
		
		Note a = new Note("a");
		Note b = new Note("b");
		Note c = new Note("c");
		Note d = new Note("d");
		
		root.addChild(a);
		root.addChild(b);
		root.addChild(c);
		root.addChild(d);
		root.addChild(new Note("I"));
		root.addChild(new Note("II"));
		root.addChild(new Note("IV"));
		
		fillComponent(a);
		fillComponent(b);
		fillComponent(c);
		fillComponent(d);
		
		
		root.display(0);
	}
	
	
	private Component fillComponent(Component component){
		component.addChild(new Note("1"));
		component.addChild(new Note("2"));
		component.addChild(new Note("3"));
		component.addChild(new Note("4"));
		component.addChild(new Note("5"));
		component.addChild(new Note("6"));
		return component;
	}
}
