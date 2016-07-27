package scenic.study.designmode.visitor.trash_in_prototype_example.core;

import scenic.study.designmode.visitor.trash_in_prototype_example.VAluminum;
import scenic.study.designmode.visitor.trash_in_prototype_example.VPage;

/**
 * Created by scenic on 16/7/26.
 */
public interface Visitor {

    void visit(VAluminum vAluminum);
    void visit(VPage vPage);
}
