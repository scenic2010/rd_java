package scenic.study.designmode.create_type.builder;

import scenic.study.designmode.create_type.builder.abstract_core.Builder;
import scenic.study.designmode.create_type.builder.abstract_core.PersonBuilder;
import scenic.study.designmode.create_type.builder.abstract_core.Product;

/**
 * Created by scenic on 16/8/10.
 */
class ConcreteImpl {

    /**
     * Created by scenic on 16/8/8.
     */
    public static class ConcreteBuilder1 implements Builder {

        private Product product = new Product();

        @Override
        public void buildPartA() {
            product.addPart("add part a");
        }

        @Override
        public void buildPartB() {
            product.addPart("add part b");
        }

        @Override
        public void buildPartC() {
            product.addPart("add part c");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    /**
     * Created by scenic on 16/8/8.
     */
    public static class ConcreteBuilder2 implements Builder{

        private Product product = new Product();

        @Override
        public void buildPartA() {
            product.addPart("add part X");
        }

        @Override
        public void buildPartB() {
            product.addPart("add part Y");
        }

        @Override
        public void buildPartC() {
            product.addPart("add part Z");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    /**
     * Created by scenic on 16/8/8.
     */
    public static class PersonFatBuilder implements PersonBuilder {
        @Override
        public void buildHeader() {
            System.out.println("创建胖人的头");
        }

        @Override
        public void buildBody() {
            System.out.println("创建胖人的身体");
        }

        @Override
        public void buildArmLeft() {
            System.out.println("创建胖人的左胳膊");
        }

        @Override
        public void buildArmRight() {
            System.out.println("创建胖人的右胳膊");
        }

        @Override
        public void buildLegLeft() {
            System.out.println("创建胖人的左腿");
        }

        @Override
        public void buildLegRight() {
            System.out.println("创建胖人的右腿");
        }
    }

    /**
     * Created by scenic on 16/8/8.
     */
    public static class PersonThinBuilder implements PersonBuilder {
        @Override
        public void buildHeader() {
            System.out.println("创建瘦人的头");
        }

        @Override
        public void buildBody() {
            System.out.println("创建瘦人的身体");
        }

        @Override
        public void buildArmLeft() {
            System.out.println("创建瘦人的左胳膊");
        }

        @Override
        public void buildArmRight() {
            System.out.println("创建瘦人的右胳膊");
        }

        @Override
        public void buildLegLeft() {
            System.out.println("创建瘦人的左腿");
        }

        @Override
        public void buildLegRight() {
            System.out.println("创建瘦人的右腿");
        }
    }

}
