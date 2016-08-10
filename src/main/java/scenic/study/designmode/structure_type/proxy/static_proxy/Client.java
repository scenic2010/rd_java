package scenic.study.designmode.structure_type.proxy.static_proxy;

/**
 * 
 * @author liuzd2 测试类
 */
public class Client {
	public static void main(String[] args) {
		//日志包时间
		{
			Tank t = new Tank();
			TankTimeProxy ttime = new TankTimeProxy(t);
			TankLogProxy tlog = new TankLogProxy(ttime);
			scenic.study.designmode.structure_type.proxy.static_proxy.Moveable m = tlog;
			m.move();
		}
		System.out.println("===========================");
		{
			//时间包这日志
			Tank t = new Tank();
			TankLogProxy tlog = new TankLogProxy(t);
			TankTimeProxy ttime = new TankTimeProxy(tlog);
			scenic.study.designmode.structure_type.proxy.static_proxy.Moveable m = ttime;
			m.move();
		}
		
	}
}
