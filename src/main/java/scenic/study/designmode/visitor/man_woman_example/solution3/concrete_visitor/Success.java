package scenic.study.designmode.visitor.man_woman_example.solution3.concrete_visitor;

import scenic.study.designmode.visitor.man_woman_example.solution3.Man;
import scenic.study.designmode.visitor.man_woman_example.solution3.Woman;
import scenic.study.designmode.visitor.man_woman_example.solution3.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class Success implements Visitor {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println("男人成功时,背后多半有一个伟大的女人");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementA) {
        System.out.println("女人成功时,背后多半有一个不成功的男人");
    }
}
