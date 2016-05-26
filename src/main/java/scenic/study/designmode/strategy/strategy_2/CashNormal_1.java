package scenic.study.designmode.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CashNormal_1 extends CashSuper{
    @Override
    public double acceptCash(double originalMoney) {
        return originalMoney;
    }
}
