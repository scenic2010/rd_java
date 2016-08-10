package scenic.study.designmode.behaviour_type.responsibility.filter_2;

import java.util.ArrayList;
import java.util.List;

public class FilterChan implements scenic.study.designmode.behaviour_type.responsibility.filter_2.Filter {
	
	List<scenic.study.designmode.behaviour_type.responsibility.filter_2.Filter> filters = new ArrayList<scenic.study.designmode.behaviour_type.responsibility.filter_2.Filter>();
	
	int index = 0;
	
	public void addFilter(scenic.study.designmode.behaviour_type.responsibility.filter_2.Filter f){
		filters.add(f);
	}


	@Override
	public void doFilter(Request request, scenic.study.designmode.behaviour_type.responsibility.filter_2.Response response, FilterChan fc) {
		if(index == filters.size()){
			index = 0;
			return;
		}
		scenic.study.designmode.behaviour_type.responsibility.filter_2.Filter f = filters.get(index);
		index ++;
		f.doFilter(request, response, fc);
	}
}

