package scenic.study.designmode.responsibility.filter_1;


public class MessageProcessor {
	String msg = null;

	FilterChan fc = null;

	public String process(){
		return fc.doFilter(msg);
	}
	
	
//	public String process(){
//		//process the html tag
//		String r = msg.replaceAll("<", "[").replaceAll(">", "]");
//		
//		//process the sensitive world
//		r = r.replaceAll("敏感", "~~");
//		
//		return r;
//	}

	public FilterChan getFc() {
		return fc;
	}


	public void setFc(FilterChan fc) {
		this.fc = fc;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
