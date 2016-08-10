package scenic.study.designmode.structure_type.composite.abstract_core;

public interface Component {
	void addChild(Component component);
	void removeChild(Component component);
	void display(int depth);
	//other method
	//.....
}
