package scenic.study.designmode.behaviour_type.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CashFactory {
    public static CashSuper createCashAccept(int type){
        CashSuper cashSuper = null;

        switch (type){
            case 0:
                cashSuper = new CashNormal_1();
                break;
            case 1:
                cashSuper = new CashRebate(0.8);
                break;
            case 2:
                cashSuper = new scenic.study.designmode.behaviour_type.strategy.strategy_2.CashReturn(300,100);
                break;
        }
        return cashSuper;
    }
}
