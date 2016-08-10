package scenic.study.designmode.create_type.factory.three_kind_factory;

import org.apache.log4j.Logger;
import org.junit.Test;

import scenic.MyLogger;

/**
 * Created by scenic on 16/7/27.
 * 探索三种工厂设计模式,
 * 简单工厂
 * 工厂方法
 * 抽象工厂
 */
public class Main {

    private static Logger logger = MyLogger.get(Main.class);

    @Test
    public void testSimpleFactory() throws Exception {
        SimpleFactory.clientTest();
    }

    @Test
    public void testFactoryMethod() {
        FactoryMethod.clientTest();
    }

    @Test
    public void testAbstractFactory() {
        AbstractFactoryTest.clientTest();
    }

    /**
     * 简单工厂
     * 定义一个用于创建对象的接口,让子类决定实例化哪一个类,工厂模式使得一个类的实例化延迟到其子类
     * 简单工厂是不符合开放-封闭原则的
     * 这里使用一个计算器的例子
     */
    static class SimpleFactory {

        public static void clientTest() throws Exception {
            System.out.println("简单工厂方法");
            OperationSimpleFactory.createOperate("+").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperate("-").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperate("*").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperate("/").setNumber(1, 2).getResult();

            System.out.println();
            System.out.println();

            System.out.println("直接在客户端调用");
            new OperationAdd().setNumber(1, 2).getResult();
            new OperationSubtract().setNumber(1, 2).getResult();
            new OperationMultiply().setNumber(1, 2).getResult();
            new OperationDivision().setNumber(1, 2).getResult();

            System.out.println();
            System.out.println();

            System.out.println("改造后的简单工厂方法");
            String rootPath = Main.class.getName();
            OperationSimpleFactory.createOperateByReflect(rootPath + "$SimpleFactory$OperationAdd").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperateByReflect(rootPath + "$SimpleFactory$OperationSubtract").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperateByReflect(rootPath + "$SimpleFactory$OperationMultiply").setNumber(1, 2).getResult();
            OperationSimpleFactory.createOperateByReflect(rootPath + "$SimpleFactory$OperationDivision").setNumber(1, 2).getResult();

        }

        static class OperationSimpleFactory {
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

            /**
             * 简单工厂和反射相结合,就会带来很大的灵活性,符合封闭-开发原则.(修改封闭,扩展开放)
             *
             * @param classNam
             * @return
             * @throws Exception
             */
            private static Operation createOperateByReflect(String classNam) throws Exception {
                Class<Operation> classZ = (Class<Operation>) Class.forName(classNam);
                Operation instance = classZ.newInstance();
                return instance;
            }

        }


        static abstract class Operation {
            protected double number1;
            protected double number2;

            public Operation setNumber(double... values) {
                number1 = values[0];
                number2 = values[1];
                return this;
            }

            abstract double getResult();
        }

        static class OperationAdd extends Operation {

            @Override
            double getResult() {
                double value = number1 + number2;
                logger.info(number1 + " + " + number2 + " = " + value);
                return value;
            }
        }

        static class OperationSubtract extends Operation {

            @Override
            double getResult() {
                double value = number1 - number2;
                logger.info(number1 + " - " + number2 + " = " + value);
                return value;
            }
        }

        static class OperationMultiply extends Operation {


            @Override
            double getResult() {
                double value = number1 * number2;
                logger.info(number1 + " * " + number2 + " = " + value);
                return value;
            }
        }

        static class OperationDivision extends Operation {

            @Override
            double getResult() {
                double value = number1 / number2;
                logger.info(number1 + " / " + number2 + " = " + value);
                return value;

            }
        }

    }

    /**
     * 工厂方法
     *
     *
     */
    static class FactoryMethod {
        public static void clientTest() {
            OperationFactory factory;
            factory = new FactoryAdd();
            factory.createOperation().setNumber(1, 2).getResult();


            factory = new FactorySubTract();
            factory.createOperation().setNumber(1, 2).getResult();

            factory = new FactoryMultiply();
            factory.createOperation().setNumber(1, 2).getResult();


            factory = new FactoryDivision();
            factory.createOperation().setNumber(1, 2).getResult();
        }

        interface OperationFactory {
            //创建一个运算符. 这里其实就是创建一个产品
            SimpleFactory.Operation createOperation();
        }

        static class FactoryAdd implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationAdd();
            }
        }

        static class FactorySubTract implements OperationFactory {
            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationSubtract();
            }
        }

        static class FactoryMultiply implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationMultiply();
            }
        }

        static class FactoryDivision implements OperationFactory {

            @Override
            public SimpleFactory.Operation createOperation() {
                return new SimpleFactory.OperationDivision();
            }
        }

    }

    /**
     * 抽象工厂
     * 提供一个创建一系列或相关依赖对象的接口,而无需指定他们具体的类[DP]
     * 创建一系列的对象,而无需指定他们具体的类[DIY]
     */
    static class AbstractFactoryTest {

        public static void clientTest() {
            CoreAbstract.AbstractFactory factory = new ConcreteFactory.DefaultAbstractFactoryImpl();


            SimpleFactory.Operation     operation   = factory.createOperation();
            CoreAbstract.Weapon         weapon      = factory.createWeapon();
            CoreAbstract.Vehicle        vehicle     = factory.createVehicle();

            executeMethod(operation,weapon,vehicle);


//            executeMethod(
//                    Access.createOperation(),
//                    Access.createWeapon(),
//                    Access.createVehicle()
//            );


        }

        private static void executeMethod(SimpleFactory.Operation operation, CoreAbstract.Weapon weapon, CoreAbstract.Vehicle vehicle) {
            operation.setNumber(1, 2).getResult();
            vehicle.run();
            weapon.shot();
        }

        static class Access {
            static String flag = "2";

            static SimpleFactory.Operation createOperation() {
                SimpleFactory.Operation operation = null;
                switch (flag) {
                    case "1":
                        operation = new SimpleFactory.OperationAdd();
                        break;
                    case "2":
                        operation = new SimpleFactory.OperationSubtract();
                        break;
                }
                return operation;
            }

            static CoreAbstract.Weapon createWeapon() {
                CoreAbstract.Weapon weapon = null;
                switch (flag) {
                    case "1":
                        weapon = new ConcreteWeapon.AK47();
                        break;
                    case "2":
                        weapon = new ConcreteWeapon.SbaYang();
                        break;
                }
                return weapon;
            }

            static CoreAbstract.Vehicle createVehicle() {

                CoreAbstract.Vehicle vehicle = null;
                switch (flag) {
                    case "1":
                        vehicle = new ConcreteVehicle.Car();
                        break;
                    case "2":
                        vehicle = new ConcreteVehicle.Plane();
                        break;
                }
                return vehicle;

            }

        }

        //所有核心的抽象
        static class CoreAbstract {
            //抽象产品1 武器
            interface Weapon {
                void shot();
            }

            //抽象产品2 交通工具
            interface Vehicle {
                void run();
            }


            //抽象工厂
            interface AbstractFactory {
                SimpleFactory.Operation createOperation();

                Weapon createWeapon();

                Vehicle createVehicle();
            }
        }

        //具体的武器的实现
        static class ConcreteWeapon {
            static class AK47 implements CoreAbstract.Weapon {

                @Override
                public void shot() {
                    logger.info("AK 47 开火了");
                }
            }

            static class SbaYang implements CoreAbstract.Weapon {

                @Override
                public void shot() {
                    logger.info("沙鹰手枪 开火了");
                }
            }
        }

        //具体交通工具的实现
        static class ConcreteVehicle {
            static class Car implements CoreAbstract.Vehicle {

                @Override
                public void run() {
                    logger.info("汽车一路冒着烟跑到了山东");
                }
            }


            static class Plane implements CoreAbstract.Vehicle {

                @Override
                public void run() {
                    logger.info("飞机一会儿飞到了济南");
                }
            }
        }

        //具体工厂的实现
        static class ConcreteFactory {

            //具体工厂1号

            static class DefaultAbstractFactoryImpl implements CoreAbstract.AbstractFactory {

                @Override
                public SimpleFactory.Operation createOperation() {
                    return new SimpleFactory.OperationAdd();
                }

                @Override
                public CoreAbstract.Weapon createWeapon() {
                    return new ConcreteWeapon.AK47();
                }

                @Override
                public CoreAbstract.Vehicle createVehicle() {
                    return new ConcreteVehicle.Car();
                }
            }

            static class DefaultAbstractFactoryImpl2 implements CoreAbstract.AbstractFactory {

                @Override
                public SimpleFactory.Operation createOperation() {
                    return new SimpleFactory.OperationSubtract();
                }

                @Override
                public CoreAbstract.Weapon createWeapon() {
                    return new ConcreteWeapon.SbaYang();
                }

                @Override
                public CoreAbstract.Vehicle createVehicle() {
                    return new ConcreteVehicle.Plane();
                }
            }

        }


    }

}
