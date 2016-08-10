package scenic.study.designmode.behaviour_type.strategy.strategy_2;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class Main {
    public static void main(String[] args){
        double money;
//        CashFactory factory = new CashFactory();
//        CashSuper cashSuper = factory.createCashAccept(2);
//        money = cashSuper.acceptCash(400);


        CashContext context = new CashContext(0);
        money = context.getResult(500);
        System.out.println("double is " + money);





    }
}
