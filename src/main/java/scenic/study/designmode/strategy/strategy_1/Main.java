package scenic.study.designmode.strategy.strategy_1;

/**
 * Created by liuzd2 on 2014/11/23.
 */
public class Main {

    public static void main(String[] args){
//        int a[] = {3,4,5,3,3,6,7,1,};
        Cat a[] = {new Cat(1,1),new Cat(4,4),new Cat(2,2)};
        DataSort.sort(a);
        DataSort.p(a);
    }
}
