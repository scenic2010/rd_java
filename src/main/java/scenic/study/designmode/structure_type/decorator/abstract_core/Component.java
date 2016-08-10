package scenic.study.designmode.structure_type.decorator.abstract_core;

/**
 * Created by scenic on 16/8/10.
 * 定义一个接口,可以给这些对象动态的添加职责
 */
public interface Component {

    void operation();

    /**
     * Created by scenic on 16/8/10.
     */
    abstract class Decorator implements Component {
        protected Component component;

        public Decorator(Component component){
            this.component = component;
        }

        @Override
        public void operation() {
            if(component != null){
                component.operation();
            }
        }
    }
}
