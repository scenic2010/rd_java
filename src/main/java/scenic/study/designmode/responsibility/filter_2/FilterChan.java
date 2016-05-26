package scenic.study.designmode.responsibility.filter_2;

import java.util.ArrayList;
import java.util.List;

public class FilterChan implements Filter{
	
	List<Filter> filters = new ArrayList<Filter>();
	
	int index = 0;
	
	public void addFilter(Filter f){
		filters.add(f);
	}


	@Override
	public void doFilter(Request request, Response response,FilterChan fc) {
		if(index == filters.size()){
			index = 0;
			return;
		}
		Filter f = filters.get(index);
		index ++;
		f.doFilter(request, response, fc);
	}
}

