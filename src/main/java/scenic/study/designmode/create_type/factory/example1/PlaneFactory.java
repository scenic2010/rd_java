package scenic.study.designmode.create_type.factory.example1;

/**
 * Created by liuzd2 on 2014/11/22.
 */
public class PlaneFactory extends VehicleFactory{
//    pubic Plane createPlane(){
////        return new Plane();
//        return null;
//    }



    @Override
    Moveable create() {
        return new Plane();
    }
}
