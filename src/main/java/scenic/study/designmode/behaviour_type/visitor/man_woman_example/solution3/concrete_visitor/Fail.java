package scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.concrete_visitor;

import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Man;
import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Woman;

/**
 * Created by scenic on 16/7/26.
 */
public class Fail implements scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core.Visitor {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println("男人失败时,闷头喝酒,谁也不同劝");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementA) {
        System.out.println("女人失败时,眼泪汪汪,谁也劝不了");
    }
}
