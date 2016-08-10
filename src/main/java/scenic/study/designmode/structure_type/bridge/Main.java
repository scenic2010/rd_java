package scenic.study.designmode.structure_type.bridge;

import scenic.study.designmode.structure_type.bridge.abstract_core.DriverManager;

/**
 * 桥接模式
 *
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化.
 * 显示系统可能有多角度分类，每一种分类都有可能变化，那么就把这种多角度分离出来让们独立变化，减少他们之间的耦合
 *
 * 如果发现继承体系中,有两个甚至多个方向的变化,那么就解耦这些不同方向的变化. 通过对象的组合的方式,把两个角色之间的继承关系改为组合的关系.
 * @author scenic
 *
 */
public class Main {

	public static void main(String[] args) {
		DriverManager driverManager = new DriverManager();
		driverManager.setDriver(new scenic.study.designmode.structure_type.bridge.jdbc.MySqlDriver());
		driverManager.add();
	}

}
