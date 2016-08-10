package scenic.study.designmode.structure_type.proxy.static_proxy;

/**
 * 代理的聚合实现，记录	Tank	时间的代理
 * @author liuzd2
 *
 */
public class TankTimeProxy implements Moveable {
	Moveable t ;

	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}


	@Override
	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();

		System.out.println("TankTimeProxytime: " + (end - start));
	}
}
