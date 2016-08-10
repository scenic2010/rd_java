package scenic.study.designmode.structure_type.proxy.dynamic_proxy;

/***
 *代理的继承实现
 *
 *如果想记录日志的话，			需要Tank3 extends Tank
 *如果想     记录时间和日志的话		需要Tank4 extends Tank2
 *如果想先记录日志后记录时间的话	需要Tank5 extends Tank
 *如果想在加入一个事务控制的话	需要Tank6 extends Tank
 * @author liuzd2
 *
 */
public class Tank2 extends Tank {

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank moveing.....");
		super.move();
		long end = System.currentTimeMillis();
		
		System.out.println("time: " + (end - start));
	}
}
