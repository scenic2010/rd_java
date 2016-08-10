package scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3;

import scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core.Person;

/**
 * Created by scenic on 16/7/26.
 */
public class Woman implements Person {


    @Override
    public void accept(scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution3.core.Visitor visitor) {
        visitor.getWomanConclusion(this);
    }
}
