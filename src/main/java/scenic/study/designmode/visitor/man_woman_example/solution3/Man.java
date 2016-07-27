package scenic.study.designmode.visitor.man_woman_example.solution3;

import scenic.study.designmode.visitor.man_woman_example.solution3.core.Person;
import scenic.study.designmode.visitor.man_woman_example.solution3.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class Man implements Person {


    @Override
    public void accept(Visitor visitor) {
        visitor.getManConclusion(this);
    }
}
