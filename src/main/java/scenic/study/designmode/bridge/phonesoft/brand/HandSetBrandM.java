package scenic.study.designmode.bridge.phonesoft.brand;

import scenic.study.designmode.bridge.phonesoft.soft.HandSetSoft;


public class HandSetBrandM extends HandSetBrand{

	public HandSetBrandM(HandSetSoft soft) {
		super(soft);
	}

	public void run(){
		soft.run();
	}
}
