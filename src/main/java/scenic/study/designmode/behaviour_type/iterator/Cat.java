package scenic.study.designmode.behaviour_type.iterator;

public class Cat {
	public Cat(int id) {
		super();
		this.id = id;
	}

	private int id;
	
	@Override
	public String toString() {
		return "cat:" + id;
	}
}
