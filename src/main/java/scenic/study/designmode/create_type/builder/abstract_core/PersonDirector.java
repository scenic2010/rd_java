package scenic.study.designmode.create_type.builder.abstract_core;

/**
 * Created by scenic on 16/8/8.
 */
public class PersonDirector {
    PersonBuilder pensionBuilder;
    public PersonDirector(PersonBuilder builder){
        this.pensionBuilder = builder;
    }

    public void createPerson() {
        pensionBuilder.buildHeader();
        pensionBuilder.buildBody();
        pensionBuilder.buildArmLeft();
        pensionBuilder.buildArmRight();
        pensionBuilder.buildLegLeft();
        pensionBuilder.buildLegRight();
    }

}
