package scenic.study.designmode.structure_type.bridge.abstract_core;

public class DriverManager {

	Driver mDriver;

	public Driver getDriver() {
		return mDriver;
	}

	public void setDriver(Driver mDriver) {
		this.mDriver = mDriver;
	}
	
	public void add(){
		mDriver.add();
	}
	
	public void delete(){
		mDriver.delete();
	}
}
