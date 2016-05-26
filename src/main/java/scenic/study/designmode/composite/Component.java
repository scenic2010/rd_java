package scenic.study.designmode.composite;

public interface Component {
	void addChild(Component component);
	void removeChild(Component compoent);
	void display(int depth);
	//other method
	//.....
}
