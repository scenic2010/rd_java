package scenic.study.designmode.structure_type.decorator;

import org.junit.Test;

import scenic.study.designmode.structure_type.decorator.abstract_core.Displayable;


/**
 * Created by scenic on 16/8/10.
 * 装饰着
 * 动态的给一个对象添加一些额外的职责,就增加功能来说,装饰着比增加子类更加的灵活
 *
 * 可以更加灵活,以动态,透明的方式给单个对象添加职责,并在不需要的时候撤销相应的职责
 */
public class Main {

    @Test
    public void testSimple() {
        ConcreteImp.ConcreteComponent cc = new ConcreteImp.ConcreteComponent();
        ConcreteImp.ConcreteDecoratorA cba = new ConcreteImp.ConcreteDecoratorA(cc);
        ConcreteImp.ConcreteDecoratorB cbb = new ConcreteImp.ConcreteDecoratorB(cba);

        cbb.operation();
    }

    @Test
    public void testPersonDecorator(){
        Displayable show1 = new ConcreteImp.TShirts(new ConcreteImp.Sunglasses(new ConcreteImp.BigTrouser(null)));
        new ConcreteImp.Person(show1).display();


        System.out.println();
        System.out.println();
        Displayable show2 = new ConcreteImp.BigTrouser(new ConcreteImp.Sunglasses(null));
        new ConcreteImp.Person(show2).display();
    }
}
