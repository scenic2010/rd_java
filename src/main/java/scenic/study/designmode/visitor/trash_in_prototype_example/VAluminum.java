package scenic.study.designmode.visitor.trash_in_prototype_example;

import scenic.study.designmode.prototype.Aluminum;
import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitable;
import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class VAluminum extends Aluminum implements Visitable {
    public VAluminum(double wt) {
        super(wt);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
