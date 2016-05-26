package scenic.study.designmode.bridge.jdbc;

public class OracleDriver implements Driver{

	@Override
	public void add() {
		System.out.println("Oracle add");
	}

	@Override
	public void delete() {
		System.out.println("Oracle delete");
	}

}
