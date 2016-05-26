package scenic.study.designmode.proxy.dynamic_proxy;
//package scenic.study.proxy.dynamic_proxy;
//
///**
// * 代理的聚合实现，记录	任何对象		时间的代理
// * @author liuzd2
// *
// */
//public class TimeProxy implements Moveable{
//	Moveable t;
//
//	public TimeProxy(Moveable t) {
//		super();
//		this.t = t;
//	}
//
//
//	@Override
//	public void move() {
//		long start = System.currentTimeMillis();
//		t.move();
//		long end = System.currentTimeMillis();
//
//		System.out.println("TankProxy move time: " + (end - start));
//	}
//
//
//	@Override
//	public void stop() {
//		long start = System.currentTimeMillis();
//		t.stop();
//		long end = System.currentTimeMillis();
//		System.out.println("TankProxy stop time: " + (end - start));
//	}
//}
