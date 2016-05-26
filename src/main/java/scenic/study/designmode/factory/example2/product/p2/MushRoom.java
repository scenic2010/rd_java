package scenic.study.designmode.factory.example2.product.p2;

import scenic.study.designmode.factory.example2.abstrac.Foot;

/**
 * 毒蘑菇
 * @author liuzd2
 *
 */
public class MushRoom  implements Foot{
	@Override
	public void getName() {
		System.out.println("magice mushRoom");
	}
}
