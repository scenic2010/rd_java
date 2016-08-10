package scenic.study.designmode.create_type.factory.spring.factory;

import java.util.Properties;

public class ClassPathXmlApplicationContext1 implements BeanFactory {
	@Override
	public Object getBean(String id) {
		try {
			Properties p = new Properties();
			p.load(scenic.study.designmode.create_type.factory.spring.factory.Main.class.getClassLoader().
					getResourceAsStream(
							"scenic/study/designmode/create_type/factory/spring/factory/spring.properties"));
			String key = (String) p.get(id);
			Object o = Class.forName(key).newInstance();
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
