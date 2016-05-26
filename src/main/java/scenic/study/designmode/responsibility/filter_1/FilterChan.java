package scenic.study.designmode.responsibility.filter_1;

import java.util.ArrayList;
import java.util.List;

public class FilterChan implements Filter{
	
	List<Filter> filters = new ArrayList<Filter>();
	
	public void addFilter(Filter f){
		filters.add(f);
	}

	@Override
	public String doFilter(String s) {
		for (Filter filter : filters) {
			s = filter.doFilter(s);
		}
		
		return s;
	}
}

