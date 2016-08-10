package scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.core;

import scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.VAluminum;

/**
 * Created by scenic on 16/7/26.
 */
public interface Visitor {

    void visit(VAluminum vAluminum);
    void visit(scenic.study.designmode.behaviour_type.visitor.trash_in_prototype_example.VPage vPage);
}
