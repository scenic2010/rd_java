package scenic.study.designmode.factory.example2;

import scenic.study.designmode.factory.example2.abstrac.AbstractFactory;
import scenic.study.designmode.factory.example2.abstrac.Foot;
import scenic.study.designmode.factory.example2.abstrac.Vehicle;
import scenic.study.designmode.factory.example2.abstrac.Weapen;
import scenic.study.designmode.factory.example2.product.p1.Ak47;
import scenic.study.designmode.factory.example2.product.p1.Apple;
import scenic.study.designmode.factory.example2.product.p1.Car;


public class DefaultFactor implements AbstractFactory{

	public Car createCar(){
		return new Car();
	}
	
	public Apple createApp(){
		return new Apple();
	}
	
	public Ak47 createAk47(){
		return new Ak47();
	}

	@Override
	public Vehicle createVehicle() {
		return null;
	}

	@Override
	public Weapen createWeapen() {
		return null;
	}

	@Override
	public Foot createFoot() {
		return null;
	}
}
