package scenic.study.designmode.factory.three_kind_factory;

import org.junit.Test;

/**
 * Created by scenic on 16/7/27.
 * 探索三种工厂设计模式,
 * 简单工厂
 * 工厂方法
 * 抽象工厂
 */
public class Main {


    @Test
    public void testSimple() {
        SimpleFactory.clientTest();
    }

    @Test
    public void testFactoryMethod(){
        FactoryMethod.clientTest();
    }

    /**
     * 简单工厂
     * 简单工厂是不符合开放-封闭原则的
     * 这里使用一个计算器的例子
     */
    public static class SimpleFactory {

        public static void clientTest() {
            System.out.println(OperationSimpleFactory.createOperate("+").setNumber(1, 2).getResult());
            System.out.println(OperationSimpleFactory.createOperate("-").setNumber(1, 2).getResult());
            System.out.println(OperationSimpleFactory.createOperate("*").setNumber(1, 2).getResult());
            System.out.println(OperationSimpleFactory.createOperate("/").setNumber(1, 2).getResult());


            new OperationAdd().setNumber(1, 2).getResult();
            new OperationSubtract().setNumber(1, 2).getResult();
            new OperationMultiply().setNumber(1, 2).getResult();
            new OperationDivision().setNumber(1, 2).getResult();

        }

        private static class OperationSimpleFactory {
            public static Operation createOperate(String operator) {
                Operation operation = null;
                switch (operator) {
                    case "+":
                        operation = new OperationAdd();
                        break;
                    case "-":
                        operation = new OperationSubtract();
                        break;
                    case "*":
                        operation = new OperationMultiply();
                        break;
                    case "/":
                        operation = new OperationDivision();
                        break;
                }
                return operation;
            }
        }

        private static abstract class Operation {
            protected double number1;
            protected double number2;

            public Operation setNumber(double... values) {
                number1 = values[0];
                number2 = values[1];
                return this;
            }

            abstract double getResult();
        }

        private static class OperationAdd extends Operation {


            @Override
            double getResult() {
                return number1 + number2;
            }
        }

        private static class OperationSubtract extends Operation {


            @Override
            double getResult() {
                return number1 - number2;
            }
        }

        private static class OperationMultiply extends Operation {


            @Override
            double getResult() {
                return number1 * number2;
            }
        }

        private static class OperationDivision extends Operation {


            @Override
            double getResult() {
                return number1 / number2;
            }
        }

    }

    public static class FactoryMethod {
        public static void clientTest() {
            OperationFactory factory;
            factory = new FactoryAdd();
            System.out.println(factory.createOperation().setNumber(1,2).getResult());

            factory = new FactorySubTract();
            System.out.println(factory.createOperation().setNumber(1,2).getResult());

            factory = new FactoryMultiply();
            System.out.println(factory.createOperation().setNumber(1,2).getResult());

            factory = new FactoryDivision();
            System.out.println(factory.createOperation().setNumber(1,2).getResult());
        }

        private interface OperationFactory {
            SimpleFactory.Operation createOperation();
        }

        public static class FactoryAdd implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationAdd();
            }
        }

        public static class FactorySubTract implements OperationFactory {
            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationSubtract();
            }
        }

        public static class FactoryMultiply implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationMultiply();
            }
        }

        public static class FactoryDivision implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationDivision();
            }
        }

    }
}
