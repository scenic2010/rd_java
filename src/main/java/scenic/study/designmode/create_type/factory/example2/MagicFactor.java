package scenic.study.designmode.create_type.factory.example2;

import scenic.study.designmode.create_type.factory.example2.abstrac.AbstractFactory;
import scenic.study.designmode.create_type.factory.example2.abstrac.Foot;
import scenic.study.designmode.create_type.factory.example2.abstrac.Vehicle;
import scenic.study.designmode.create_type.factory.example2.abstrac.Weapen;
import scenic.study.designmode.create_type.factory.example2.product.p1.Car;
import scenic.study.designmode.create_type.factory.example2.product.p2.MagiceWeapen;


public class MagicFactor implements AbstractFactory{

	public Car createBloom(){
		return new Car();
	}
	
	public scenic.study.designmode.create_type.factory.example2.product.p2.MushRoom createMushRoom(){
		return new scenic.study.designmode.create_type.factory.example2.product.p2.MushRoom();
	}
	
	public MagiceWeapen createMagicState(){
		return new MagiceWeapen();
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
