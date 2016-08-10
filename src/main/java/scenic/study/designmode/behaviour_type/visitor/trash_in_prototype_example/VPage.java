package scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example;

import scenic.study.designmode.create_type.prototype.Paper;
import scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class VPage extends Paper implements scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.core.Visitable {
    public VPage(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
