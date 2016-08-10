package scenic.study.designmode.structure_type.composite.abstract_core;

/**
 * Created by scenic on 16/8/10.
 */
public class Leaf implements Component{
    private String name;
    public Leaf(String name){
        this.name = name;
    }
    @Override
    public void addChild(Component component) {
        throw new RuntimeException("can not to be add in Leaf");
    }

    @Override
    public void removeChild(Component component) {
        throw new RuntimeException("can not to be remove in Leaf");
    }

    @Override
    public void display(int depth) {
        for(int i = 0; i < depth ;i++){
            System.out.print("\t");
        }
        System.out.println(name);

    }
}
