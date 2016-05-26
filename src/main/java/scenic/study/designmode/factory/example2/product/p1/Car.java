package scenic.study.designmode.factory.example2.product.p1;

import scenic.study.designmode.factory.example2.abstrac.Vehicle;

/**
 * Created by liuzd2 on 2014/11/22.
 */
public class Car implements Vehicle {
    public void run(){
        System.out.println("冒着烟去东北");
        System.out.println();
    }
}
