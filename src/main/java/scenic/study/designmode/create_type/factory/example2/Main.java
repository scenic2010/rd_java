package scenic.study.designmode.create_type.factory.example2;

import scenic.study.designmode.create_type.factory.example2.product.p1.Apple;
import scenic.study.designmode.create_type.factory.example2.product.p1.Car;

/**
 * Created by liuzd2 on 2014/11/22.
 *
 *
 * 抽象工厂
 */
public class Main {
    public void main(String args[]) {

    	DefaultFactor f = new DefaultFactor();
        Car car = f.createCar();
        car.run();;
        scenic.study.designmode.create_type.factory.example2.product.p1.Ak47 ak = f.createAk47();
        ak.shoot();;

        Apple a = f.createApp();
        a.getName();

    }

}
