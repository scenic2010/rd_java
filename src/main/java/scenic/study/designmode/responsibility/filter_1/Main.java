package scenic.study.designmode.responsibility.filter_1;


/**
 * 责任链模式
 * 增加了FilterChan的设计 
 * @author liuzd2
 */
public class Main {

	public static void main(String[] args) {
		String msg = "大家好：) 敏感，被就业<script>";
		
		{
			MessageProcessor messageProcess = new MessageProcessor();
			messageProcess.setMsg(msg);
			FilterChan fc1 = getFilterChan1();
			FilterChan fc2 = getFilterChan2();
			fc1.addFilter(fc2);
			messageProcess.setFc(fc1);
			String result = messageProcess.process();
			System.out.println(result);
		}
		
	}

	private static FilterChan getFilterChan1() {
		FilterChan fc1 = new FilterChan();
		fc1.addFilter(new HtmlFilter());
		fc1.addFilter(new SensitiveFilter());
		return fc1;
	}
	private static FilterChan getFilterChan2() {
		FilterChan fc1 = new FilterChan();
		fc1.addFilter(new HtmlFilter());
		fc1.addFilter(new SensitiveFilter());
		return fc1;
	}
}
