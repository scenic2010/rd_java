package scenic.study.designmode.create_type.builder;

import org.junit.Test;

import scenic.study.designmode.create_type.builder.abstract_core.Builder;
import scenic.study.designmode.create_type.builder.abstract_core.Director;
import scenic.study.designmode.create_type.builder.abstract_core.PersonDirector;
import scenic.study.designmode.create_type.builder.abstract_core.Product;

/**
 * Created by scenic on 16/8/8.
 * 建造者
 * 将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示
 */
public class Main {

    @Test
    public void testCommon(){
        Director director = new Director();
        Builder builder1 = new ConcreteImpl.ConcreteBuilder1();

        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();


        Builder builder2 = new ConcreteImpl.ConcreteBuilder2();
        director.construct(builder2);

        Product product2 = builder2.getResult();
        product2.show();
    }

    @Test
    public void testBuilderPension() {

        {
            PersonDirector director = new PersonDirector(new ConcreteImpl.PersonThinBuilder());
            director.createPerson();
        }

        System.out.println("=============");

        {
            PersonDirector director = new PersonDirector(new ConcreteImpl.PersonFatBuilder());
            director.createPerson();
        }
    }

}
