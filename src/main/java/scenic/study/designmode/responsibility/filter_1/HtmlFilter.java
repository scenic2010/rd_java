package scenic.study.designmode.responsibility.filter_1;


public class HtmlFilter implements Filter{


	@Override
	public String doFilter(String s) {
		String r = s.replaceAll("<", "[").replaceAll(">", "]");
		return r;
	}

}
