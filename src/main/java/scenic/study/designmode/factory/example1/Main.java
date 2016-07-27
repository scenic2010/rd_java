package scenic.study.designmode.factory.example1;

/**
 * Created by liuzd2 on 2014/11/22.
 */
public class Main {
    public void main(String args[]) {
        VehicleFactory factory = new PlaneFactory();
        Moveable move = factory.create();
        move.run();
    }

}
