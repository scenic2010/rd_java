package scenic.study.designmode.visitor.trash_in_prototype_example;

import scenic.study.designmode.prototype.Paper;
import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitable;
import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class VPage extends Paper implements Visitable {
    public VPage(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
