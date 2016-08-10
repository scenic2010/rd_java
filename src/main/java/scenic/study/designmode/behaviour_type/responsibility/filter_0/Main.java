package scenic.study.designmode.behaviour_type.responsibility.filter_0;


/**
 * 责任链模式，
 * 简单版本
 * @author liuzd2
 */
public class Main {

	public static void main(String[] args) {
		String msg = "大家好：) 敏感，被就业<script>";
		{
			MessageProcessor mp = new MessageProcessor();
			mp.setMsg(msg);
			String result = mp.process();
			System.out.println(result);
		}
		
	}
}
