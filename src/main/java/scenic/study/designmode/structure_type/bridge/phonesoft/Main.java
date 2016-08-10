package scenic.study.designmode.structure_type.bridge.phonesoft;

import scenic.study.designmode.structure_type.bridge.phonesoft.brand.HandSetBrandM;
import scenic.study.designmode.structure_type.bridge.phonesoft.soft.HandSetGame;

public class Main {

	public static void main(String[] args) {
		
		new HandSetBrandM(new HandSetGame()).run();
		
	}

}
