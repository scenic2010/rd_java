package scenic.study.designmode.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CashContext {
    CashSuper cashSuper = null;

    public CashContext(int type){
        switch (type){
            case 0:
                cashSuper = new CashNormal_1();
                break;
            case 1:
                cashSuper = new CashRebate(0.8);
                break;
            case 2:
                cashSuper = new CashReturn(300,100);
                break;
        }
    }
    public double getResult(double monkey){
        return cashSuper.acceptCash(monkey);
    }

}
