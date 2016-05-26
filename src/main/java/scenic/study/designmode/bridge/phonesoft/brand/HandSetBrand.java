package scenic.study.designmode.bridge.phonesoft.brand;

import scenic.study.designmode.bridge.phonesoft.soft.HandSetSoft;

public abstract class HandSetBrand {

	protected HandSetSoft soft;
	
	public HandSetBrand(HandSetSoft soft) {
		this.soft = soft;
	}
	
	public void run(){
		soft.run();
	}
}
