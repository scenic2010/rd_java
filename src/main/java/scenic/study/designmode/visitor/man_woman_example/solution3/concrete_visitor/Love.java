package scenic.study.designmode.visitor.man_woman_example.solution3.concrete_visitor;

import scenic.study.designmode.visitor.man_woman_example.solution3.Man;
import scenic.study.designmode.visitor.man_woman_example.solution3.Woman;
import scenic.study.designmode.visitor.man_woman_example.solution3.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class Love implements Visitor {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println("男人恋爱时,凡是不懂也要装懂");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementA) {
        System.out.println("女人恋爱时,遇事懂也装作不懂");
    }
}
