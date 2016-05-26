package scenic.study.designmode.responsibility.common;

public class GeneralManager implements Manager {

	private Manager manager = null;
	
	public void setManager(Manager manager){
		this.manager =  manager;
	}

	@Override
	public void doDealRequest(Request request, Response respons) {
		if(request.type == 0){
			//self deal
		}else{
			manager.doDealRequest(request, respons);
		}
	}

}
