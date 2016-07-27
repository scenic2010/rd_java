package scenic.study.designmode.visitor.man_woman_example.solution2;

/**
 * Created by scenic on 16/7/25.
 */
public abstract class Person {

    private State state;

    public abstract void getConclusion() ;

    public Person(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

}
