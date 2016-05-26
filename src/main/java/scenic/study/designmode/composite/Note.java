package scenic.study.designmode.composite;

import java.util.ArrayList;
import java.util.List;

public class Note implements Component{

	private String name;
	
	private List<Component> mChilds = new ArrayList<Component>();
	
	
	public Note(String name) {
		this.name = name;
	}
	
	@Override
	public void addChild(Component component) {
		mChilds.add(component);
	}

	@Override
	public void removeChild(Component compoent) {
		mChilds.remove(compoent);
	}

	@Override
	public void display(int depth) {
		for(int i = 0; i < depth ;i++){
			System.out.print("\t");
		}
		System.out.println(name);
		for (Component note : mChilds) {
			note.display(depth+1);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
