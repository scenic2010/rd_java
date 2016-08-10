package scenic.study.designmode.structure_type.bridge.phonesoft.brand;


public class HandSetBrandM extends HandSetBrand{

	public HandSetBrandM(scenic.study.designmode.structure_type.bridge.phonesoft.soft.HandSetSoft soft) {
		super(soft);
	}

	public void run(){
		soft.run();
	}
}
