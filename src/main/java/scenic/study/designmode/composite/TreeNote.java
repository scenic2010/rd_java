package scenic.study.designmode.composite;

import java.util.ArrayList;
import java.util.List;

public class TreeNote {
	
	private List<TreeNote> mChilds = new ArrayList<TreeNote>();
	private TreeNote parent = null;
	private String name;

	public TreeNote(String name) {
		this.name = name;
	}
	
	public TreeNote getParent() {
		return parent;
	}

	public void setParent(TreeNote parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNote addChilder(TreeNote childer) {
		mChilds.add(childer);
		return this;
	}

	public TreeNote removeChilder(TreeNote childer) {
		mChilds.remove(childer);
		return this;
	}

	public List<TreeNote> getChildren() {
		return  mChilds;
	}

	public void printSelf() {
		System.out.println(name);
		printChilds(mChilds , 1);
	}

	private void printChilds(List<TreeNote> childs,int printIndex){
		for (TreeNote treeNote : childs) {
			int treeIndex = getTreeIndex(treeNote);
			for(int i = 0; i < treeIndex ; i++){
				System.out.print("\t");
			}
			System.out.println(treeNote.getName());
			printChilds(treeNote.getChildren(),printIndex++);
		}
	}


	private int getTreeIndex(TreeNote treeNote) {
		int index = 0;
		TreeNote  parent =treeNote.getParent();
		while(parent  != null){
			index++;
			parent = parent.getParent();
		}
		return index;
	}
	
}
