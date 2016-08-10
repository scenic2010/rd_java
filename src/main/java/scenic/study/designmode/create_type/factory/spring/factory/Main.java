package scenic.study.designmode.create_type.factory.spring.factory;


/**
 * Created by liuzd2 on 2014/11/22.
 * 
 * 
 * bean工厂
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// Moveable m = new Car();
		// m.run();

		BeanFactory b = new ClassPathXmlApplicationContext1();
		scenic.study.designmode.create_type.factory.spring.factory.product.Moveable m =  (scenic.study.designmode.create_type.factory.spring.factory.product.Moveable) b.getBean("VehicleType");
		m.run();
	}

}
