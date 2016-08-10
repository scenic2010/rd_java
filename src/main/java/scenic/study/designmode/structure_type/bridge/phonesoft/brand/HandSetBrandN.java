package scenic.study.designmode.structure_type.bridge.phonesoft.brand;


public class HandSetBrandN extends HandSetBrand {

	public HandSetBrandN(scenic.study.designmode.structure_type.bridge.phonesoft.soft.HandSetSoft soft) {
		super(soft);
	}

	public void run(){
		soft.run();
	}
}
