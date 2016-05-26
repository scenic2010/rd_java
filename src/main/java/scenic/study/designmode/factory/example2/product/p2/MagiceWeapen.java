package scenic.study.designmode.factory.example2.product.p2;

import scenic.study.designmode.factory.example2.abstrac.Weapen;

public class MagiceWeapen implements Weapen{

	@Override
	public void shoot() {
		System.out.println("magice shoot");
	}

}
