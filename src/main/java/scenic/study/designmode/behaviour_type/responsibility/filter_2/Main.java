package scenic.study.designmode.behaviour_type.responsibility.filter_2;


/**
 * 责任链模式
 * 增加了FilterChan的设计 
 * 完善过滤器的功能，增加过滤双向的消息
 * 过滤消息是需要走一个循环，如图
 * @author liuzd2
 */
public class Main {

	public static void main(String[] args) {
		String msg = "大家好：) 敏感，被就业<script>";
		
		{
			Request request = new Request();
			request.setStr(msg);
			scenic.study.designmode.behaviour_type.responsibility.filter_2.Response response = new scenic.study.designmode.behaviour_type.responsibility.filter_2.Response();
			
			scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan fc1 = getFilterChan1();
//			FilterChan fc2 = getFilterChan2();
//			fc1.addFilter(f);
			fc1.doFilter(request, response,fc1);
			System.out.println(request.getStr());
			System.out.println(response.getStr());
		}
		
	}

	private static scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan getFilterChan1() {
		scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan fc1 = new scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan();
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_2.HtmlFilter());
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_2.SensitiveFilter());
		return fc1;
	}
	private static scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan getFilterChan2() {
		scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan fc1 = new scenic.study.designmode.behaviour_type.responsibility.filter_2.FilterChan();
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_2.HtmlFilter());
		fc1.addFilter(new scenic.study.designmode.behaviour_type.responsibility.filter_2.SensitiveFilter());
		return fc1;
	}
}
