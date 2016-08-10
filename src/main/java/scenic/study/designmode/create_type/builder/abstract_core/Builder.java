package scenic.study.designmode.create_type.builder.abstract_core;

/**
 * Created by scenic on 16/8/8.
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();

    Product getResult();
}
