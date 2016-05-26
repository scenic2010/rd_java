package scenic.study.designmode.bridge.jdbc;

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
