package scenic.study.designmode.structure_type.bridge.jdbc;

import scenic.study.designmode.structure_type.bridge.abstract_core.Driver;

public class OracleDriver implements Driver {

	@Override
	public void add() {
		System.out.println("Oracle add");
	}

	@Override
	public void delete() {
		System.out.println("Oracle delete");
	}

}
