package scenic.study.designmode.bridge.phonesoft;

import scenic.study.designmode.bridge.phonesoft.brand.HandSetBrandM;
import scenic.study.designmode.bridge.phonesoft.soft.HandSetGame;

public class Main {

	public static void main(String[] args) {
		
		new HandSetBrandM(new HandSetGame()).run();;
		
	}

}
