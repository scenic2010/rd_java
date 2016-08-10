package scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core;


import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Man;
import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.Woman;

/**
 * Created by scenic on 16/7/26.
 * 状态对象
 */
public interface  Visitor {
    void getManConclusion(Man concreteElementA);
    void getWomanConclusion(Woman concreteElementA);
}
