package scenic.study.designmode.bridge.phonesoft.brand;

import scenic.study.designmode.bridge.phonesoft.soft.HandSetSoft;


public class HandSetBrandN extends HandSetBrand{

	public HandSetBrandN(HandSetSoft soft) {
		super(soft);
	}

	public void run(){
		soft.run();
	}
}
