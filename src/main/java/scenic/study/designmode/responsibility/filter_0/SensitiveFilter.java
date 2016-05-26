package scenic.study.designmode.responsibility.filter_0;


public class SensitiveFilter implements Filter{


	@Override
	public String doFilter(String s) {
		String r = s.replaceAll("敏感", "~~");
		return r;
	}

}
