package scenic.study.designmode.structure_type.composite;

import org.junit.Test;

import scenic.study.designmode.structure_type.composite.abstract_core.Component;
import scenic.study.designmode.structure_type.composite.abstract_core.Leaf;
import scenic.study.designmode.structure_type.composite.abstract_core.Note;

/**
 * 组合模式
 * 部分和整体的关系，一般将对象组合成树形的结构表示部分和整体的层次关系
 *
 * 客户可以一致的使用组合结构和单个对象. 任何用到基本对象的地方都可以使用组合对象.
 *
 */
public class Main {

	
	public static void main(String[] args) {
		
	}

	
	
	
	@Test
	public void testNote(){
		//测试树状展现
		Component root = new Note("root");

		Component a = new Note("a");
		Component b = new Note("b");
		Component c = new Note("c");
		Component d = new Note("d");
		
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
		component.addChild(new Leaf("7"));
		return component;
	}
}
