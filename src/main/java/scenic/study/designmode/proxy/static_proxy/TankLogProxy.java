package scenic.study.designmode.proxy.static_proxy;


/**
 * 代理的聚合实现,记录日志的代理
 * @author liuzd2
 *
 */
public class TankLogProxy implements Moveable{
	Moveable t;

	public TankLogProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		System.out.println("TankLogProxy:tank start.....");
		t.move();
		System.out.println("TankLogProxy:tank stop.....");
	}
}
