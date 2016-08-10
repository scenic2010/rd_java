package scenic.study.designmode.behaviour_type.responsibility.filter_2;


public class HtmlFilter implements Filter {



	@Override
	public void doFilter(Request request, scenic.study.designmode.behaviour_type.responsibility.filter_2.Response response, FilterChan fc) {
		request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "---HtmlFilter---";
		fc.doFilter(request, response, fc);
		response.str = response.str += "---HtmlFilter---";
	}

}
