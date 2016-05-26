package scenic.study.designmode.proxy.dynamic_proxy;


public class Tank implements Moveable {

	@Override
	public void move() {
//		long start = System.currentTimeMillis();
		System.out.println("Takn:Tank moveing.....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		long end = System.currentTimeMillis();
//		
//		System.out.println("time: " + (end - start));
	}

	@Override
	public void stop() {
		System.out.println("Tank Tank stop....");
	}

}
