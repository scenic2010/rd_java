package scenic.study.designmode.create_type.builder.abstract_core;

/**
 * Created by scenic on 16/8/8.
 */
public class Director {
    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
