package scenic.study.designmode.structure_type.proxy.dynamic_proxy;

import java.lang.reflect.Method;


/**
 * 
 * @author liuzd2 测试类
 */
public class Client {
	public static void main(String[] args) throws Exception {
		// 日志包时间
		{
			Moveable ttime = (Moveable) Proxy.newProxyInstance(Moveable.class, new MyTimeProxy(new Tank()));
			ttime.move();
		}
	}

	// 可以对任意的对象，任意的接口对象实现接口代理
	static class MyTimeProxy implements InvocationHandler {

		public MyTimeProxy(Moveable m) {
			target = m;
		}

		Moveable target;

		@Override
		public void invoke(Object obj, Method m) {

			long start = System.currentTimeMillis();
			try {
				m.invoke(target);
			} catch (Exception e) {

			}

			long end = System.currentTimeMillis();
			System.out.println("TankTimeProxytime: " + (end - start));
		}

	}
}
