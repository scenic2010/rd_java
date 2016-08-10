package scenic.study.designmode.behaviour_type.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class CashReturn extends CashSuper{

    private double monkeyCondition = 0;
    private double monkeyReturn = 0;

    public CashReturn(double monkeyCondition, double monkeyReturn) {
        this.monkeyCondition = monkeyCondition;
        this.monkeyReturn = monkeyReturn;
    }

    public double acceptCash(double originalMoney) {
        double result = originalMoney;
        if(originalMoney >= monkeyCondition){
            result = originalMoney - (originalMoney/monkeyCondition) * monkeyReturn ;
        }
        return result;
    }
}
