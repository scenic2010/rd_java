package scenic.study.designmode.behaviour_type.responsibility.filter_2;


public class SensitiveFilter implements Filter {

	@Override
	public void doFilter(scenic.study.designmode.behaviour_type.responsibility.filter_2.Request request, scenic.study.designmode.behaviour_type.responsibility.filter_2.Response response, FilterChan fc) {
		request.str = request.str.replaceAll("敏感", "~~") + "---SensitiveFilter---";
		fc.doFilter(request, response, fc);
		response.str = response.str += "---SensitiveFilter---";
	}

}
