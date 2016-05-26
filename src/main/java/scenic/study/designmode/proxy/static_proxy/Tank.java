package scenic.study.designmode.proxy.static_proxy;


public class Tank implements Moveable {

	@Override
	public void move() {
		System.out.println("Takn:Tank moveing.....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
