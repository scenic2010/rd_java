package scenic.study.designmode.create_type.builder.abstract_core;

/**
 * Created by scenic on 16/8/8.
 */
public interface PersonBuilder {
    void buildHeader();

    void buildBody();

    void buildArmLeft();

    void buildArmRight();

    void buildLegLeft();

    void buildLegRight();
}
