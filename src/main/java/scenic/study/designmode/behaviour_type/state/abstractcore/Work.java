package scenic.study.designmode.behaviour_type.state.abstractcore;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class Work {
    State state;
    public int hour;

    public Work() {
        state = new scenic.study.designmode.behaviour_type.state.concretestate.ForenoonState();
    }


    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void writeProgram() {
        state.waiteProgram(this);
    }

}
