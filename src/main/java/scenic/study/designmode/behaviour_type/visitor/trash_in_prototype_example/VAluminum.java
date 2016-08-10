package scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example;

import scenic.study.designmode.create_type.prototype.Aluminum;

/**
 * Created by scenic on 16/7/26.
 */
public class VAluminum extends Aluminum implements scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.core.Visitable {
    public VAluminum(double wt) {
        super(wt);
    }

    @Override
    public void accept(scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.core.Visitor visitor) {
        visitor.visit(this);
    }
}
