package scenic.study.designmode.responsibility.filter_2;


public class SensitiveFilter implements Filter{

	@Override
	public void doFilter(Request request, Response response,FilterChan fc) {
		request.str = request.str.replaceAll("敏感", "~~") + "---SensitiveFilter---";
		fc.doFilter(request, response, fc);
		response.str = response.str += "---SensitiveFilter---";
	}

}
