package scenic.study.designmode.structure_type.decorator;

import scenic.study.designmode.structure_type.decorator.abstract_core.Component;
import scenic.study.designmode.structure_type.decorator.abstract_core.Displayable;

/**
 * Created by scenic on 16/8/10.
 */
class ConcreteImp {

    public static class ConcreteDecoratorA extends Component.Decorator {

        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("执行具体装饰者A的操作");
        }
    }

    public static class ConcreteDecoratorB extends Component.Decorator {

        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("执行具体装饰者B的操作");
        }
    }

    public static class ConcreteComponent implements Component {

        @Override
        public void operation() {
            System.out.println("具体的 Component");
        }
    }



    public static class Person extends Displayable.Finery {


        public Person(Displayable displayable) {
            super(displayable);
        }
    }

    public static class TShirts extends Displayable.Finery {

        public TShirts(Displayable displayable) {
            super(displayable);
        }

        @Override
        public void display() {
            super.display();
            System.out.println("穿上了大T恤");
        }
    }


    public static class BigTrouser extends Displayable.Finery {

        public BigTrouser(Displayable displayable) {
            super(displayable);
        }

        @Override
        public void display() {
            super.display();
            System.out.println("穿上垮裤");
        }
    }

    public static class Sunglasses extends Displayable.Finery {

        public Sunglasses(Displayable displayable) {
            super(displayable);
        }

        @Override
        public void display() {
            super.display();
            System.out.println("带上了墨镜");
        }
    }


}
