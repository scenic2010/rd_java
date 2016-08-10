package scenic.study.designmode.structure_type.adapter;

import org.junit.Test;

/**
 * Created by scenic on 16/8/9.
 * 适配器
 * 将一个类的接口转换成客户希望的另外一个接口. adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * <p/>
 * <p/>
 * Android 的 ListView 和 Adapter解释 , 由于数据源有很多,这些数据组织上有很多不同之处,但是我们希望得到统一的数据格式,此时就用Adapter
 *
 * 想使用一个已经存在的类,而它的接口不符合要求,或者希望创建一个可以复用的类,该类可以与其他不相关的类或者不可预见的类协同工作
 */
public class Main {

    static abstract class Player {
        protected String name;

        public Player(String name) {
            this.name = name;
        }

        abstract void attack();

        abstract void defense();
    }

    /**
     * 前锋
     */
    static class Forwards extends Player {

        public Forwards(String name) {
            super(name);
        }

        @Override
        void attack() {
            System.out.println("前锋 " + name + " attack");
        }

        @Override
        void defense() {
            System.out.println("前锋 " + name + " defense");
        }
    }


    /**
     * 中锋
     */
    static class Center extends Player {

        public Center(String name) {
            super(name);
        }

        @Override
        void attack() {
            System.out.println("中锋 " + name + " attack");
        }

        @Override
        void defense() {
            System.out.println("中锋 " + name + " defense");
        }
    }

    /**
     * 外籍中锋
     */
    static class ForeignCenter {
        String name;

        public ForeignCenter(String name) {
            this.name = name;
        }

        void 进攻() {
            System.out.println("中锋 " + name + " attack");
        }

        void 防守() {
            System.out.println("中锋 " + name + " defense");
        }
    }


    static class TranslatorAdapter extends Player {

        ForeignCenter foreignCenter;

        public TranslatorAdapter(String name) {
            super(name);
            foreignCenter = new ForeignCenter("姚明");
        }

        @Override
        void attack() {
            foreignCenter.进攻();
        }

        @Override
        void defense() {
            foreignCenter.防守();
        }
    }

    /**
     * 后卫
     */
    static class Guards extends Player {

        public Guards(String name) {
            super(name);
        }

        @Override
        void attack() {
            System.out.println("后卫 " + name + " attack");
        }

        @Override
        void defense() {
            System.out.println("后卫 " + name + " defense");
        }
    }


    @Test
    public void testNormal() {
        Player a = new Forwards("巴蒂尔");
        a.attack();

        Player b = new Forwards("麦克格蕾姆");
        b.attack();

        Player ym = new TranslatorAdapter("姚明");
//        Player ym = new Center("姚明");
        ym.attack();
        ym.defense();


    }
}
