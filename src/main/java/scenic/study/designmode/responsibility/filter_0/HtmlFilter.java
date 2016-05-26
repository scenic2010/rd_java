package scenic.study.designmode.responsibility.filter_0;


public class HtmlFilter implements Filter{


	@Override
	public String doFilter(String s) {
		String r = s.replaceAll("<", "[").replaceAll(">", "]");
		return r;
	}

}
