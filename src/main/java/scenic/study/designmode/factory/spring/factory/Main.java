package scenic.study.designmode.factory.spring.factory;

import java.io.IOException;
import java.util.Properties;

import scenic.study.designmode.factory.spring.factory.product.Moveable;


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
		Moveable m =  (Moveable) b.getBean("VehicleType");
		m.run();
	}

}
