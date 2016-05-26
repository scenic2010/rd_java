package scenic.study.designmode.factory.spring.factory;

import java.io.IOException;
import java.util.Properties;

import scenic.study.designmode.factory.spring.factory.product.Moveable;

public class ClassPathXmlApplicationContext1 implements BeanFactory{
	@Override
	public Object getBean(String id) {
		try {
			Properties p = new Properties();
			p.load(Main.class.getClassLoader().
					getResourceAsStream(
					"scenic/study/designmode/factory/spring/factory/spring.properties"));
			String key = (String) p.get(id);
			Object o = Class.forName(key).newInstance();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
