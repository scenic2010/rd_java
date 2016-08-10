package scenic.study.designmode.structure_type.facade;

/**
 * 探讨外观模式
 * @author scenic
 *
 * 为子系统的一组接口提供一个一致的界面,此模式定义了一个高层接口,这个接口使得这个子系统更加容易使用
 */
public class Main {

	public static void main(String[] args) {
		  Computer computer = new Computer();
	        computer.startup();  
	        computer.shutdown();  
	}

}
