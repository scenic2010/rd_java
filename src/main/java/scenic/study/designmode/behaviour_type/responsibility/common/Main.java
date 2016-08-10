package scenic.study.designmode.behaviour_type.responsibility.common;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {
		
		
	}
	
	/**
	 * 核心是一个manager调用下一个manager的doDealRequest方法
	 * 每个manager持有对下一个manager的引用
	 */
	@Test
	public void testMain(){
		CommonManager common = new CommonManager();
		CommonManager genenr = new CommonManager();
		common.setManager(genenr);
		common.doDealRequest(new Request(),new Response());
	}

	
}
