package scenic.study.designmode.state;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class Work {
    State state;
    public int hour;

    Work(){
        state = new ForenoonState();

    }


    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void wiriteProgram(){
        state.wirteProgram(this);
    }

}
