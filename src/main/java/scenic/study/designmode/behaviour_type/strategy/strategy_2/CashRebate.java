package scenic.study.designmode.behaviour_type.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CashRebate extends CashSuper{

    double moneyRebate = 0;

    public CashRebate(double monkeyRebtate){
        this.moneyRebate = monkeyRebtate;
    }


    @Override
    public double acceptCash(double originalMoney) {
        return originalMoney * moneyRebate;
    }
}
