package scenic.study.designmode.structure_type.bridge.jdbc;

import scenic.study.designmode.structure_type.bridge.abstract_core.Driver;

public class MySqlDriver implements Driver {

	@Override
	public void add() {
		System.out.println("MySql add");
	}

	@Override
	public void delete() {
		System.out.println("MySql delete");
	}

}
