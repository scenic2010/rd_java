package scenic.study.designmode.bridge.jdbc;

public class MySqlDriver implements Driver{

	@Override
	public void add() {
		System.out.println("MySql add");
	}

	@Override
	public void delete() {
		System.out.println("MySql delete");
	}

}
