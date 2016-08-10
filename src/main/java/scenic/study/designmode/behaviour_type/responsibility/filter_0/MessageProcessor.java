package scenic.study.designmode.behaviour_type.responsibility.filter_0;


public class MessageProcessor {
	String msg = null;
	Filter[] filters =  {
		new HtmlFilter(),
		new SensitiveFilter()
	};
	

	public String process(){
		String r = msg;
		for (Filter filter : filters) {
			r = filter.doFilter(r);
		}
		return r;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
