package scenic.study.designmode.behaviour_type.responsibility.filter_1;


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
			scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan fc1 = getFilterChan1();
			scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan fc2 = getFilterChan2();
			fc1.addFilter(fc2);
			messageProcess.setFc(fc1);
			String result = messageProcess.process();
			System.out.println(result);
		}
		
	}

	private static scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan getFilterChan1() {
		scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan fc1 = new scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan();
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_1.HtmlFilter());
		fc1.addFilter(new SensitiveFilter());
		return fc1;
	}
	private static scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan getFilterChan2() {
		scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan fc1 = new scenic.study.designmode.behaviour_type.responsibility.filter_1.FilterChan();
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_1.HtmlFilter());
		fc1.addFilter(new SensitiveFilter());
		return fc1;
	}
}
