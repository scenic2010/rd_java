package scenic.study.designmode.structure_type.bridge.phonesoft.brand;

public abstract class HandSetBrand {

	protected scenic.study.designmode.structure_type.bridge.phonesoft.soft.HandSetSoft soft;
	
	public HandSetBrand(scenic.study.designmode.structure_type.bridge.phonesoft.soft.HandSetSoft soft) {
		this.soft = soft;
	}
	
	public void run(){
		soft.run();
	}
}
