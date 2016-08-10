package scenic.study.designmode.behaviour_type.visitor;

import org.junit.Test;

import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Execute;

/**
 * Created by scenic on 16/7/25.
 * 访问者模式
 */
public class Main {

    /**
     * 大话设计模式,男人和女人
     */
    public static class ManAndWomanTest {


        @Test
        public void testSolution1() {
            System.out.println("男人成功时,背后多半有一个伟大的女人");
            System.out.println("女人成功时,背后多半有一个不成功的男人");

            System.out.println("男人失败时,闷头喝酒,谁也不同劝");
            System.out.println("女人失败时,眼泪汪汪,谁也劝不了");

            System.out.println("男人恋爱时,凡是不懂也要装懂");
            System.out.println("女人恋爱时,遇事懂也装作不懂");

        }

        @Test
        public void testSolution2() {
            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Man(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.fail).getConclusion();
            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Woman(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.fail).getConclusion();


            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Man(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.love).getConclusion();
            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Woman(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.love).getConclusion();

            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Man(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.success).getConclusion();
            new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.Woman(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2.State.success).getConclusion();

        }

        /**
         * 访问者,就是让接口Visitor 访问 具体的对象.
         * 访问者的好处就是增加新的操作很容易.但是如果增加新的数据结构类(Element)就很困难,所以使用的前提是系统的数据结构对象稳定,不容易变化.
         */
        @Test
        public void testSolution3() {
            Execute execute =
                    new Execute();

            execute.execute(new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.concrete_visitor.Success());
            execute.execute(new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.concrete_visitor.Love());
            execute.execute(new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.concrete_visitor.Fail());

            scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core.Visitor marriage = new scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core.Visitor() {
                @Override
                public void getManConclusion(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Man concreteElementA) {
                    System.out.println("男人结婚时,感慨道:恋爱游戏终结时,''有妻徒刑',遥遥无期");
                }

                @Override
                public void getWomanConclusion(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Woman concreteElementA) {
                    System.out.println("女人结婚时,欣慰日:爱情长跑路漫漫,婚姻保险保平安");
                }
            };

            execute.execute(marriage);
        }

        @Test
        public void testThePatterWithPrototypeExample() {
            scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.Execute execute = new scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.Execute();


            execute.execute();

        }
    }
}
