package scenic.study.designmode.visitor.man_woman_example.solution3.core;

/**
 * Created by scenic on 16/7/25.
 */
public interface Person {
    void accept(Visitor visitor);
}
