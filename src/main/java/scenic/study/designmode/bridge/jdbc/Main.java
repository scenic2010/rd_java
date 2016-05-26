package scenic.study.designmode.bridge.jdbc;
/**
 * 桥接模式
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，
 * 显示系统可能有多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来让们独立变化，减少他们之间的耦合
 * @author scenic
 *
 */
public class Main {

	public static void main(String[] args) {
		DriverManager driverManager = new DriverManager();
		driverManager.setDriver(new MySqlDriver());
		driverManager.add();
	}

}
