package scenic.study.designmode.visitor.trash_in_prototype_example.core;

/**
 * Created by scenic on 16/7/26.
 */
public interface Visitable {
    void accept(Visitor visitor);
}
