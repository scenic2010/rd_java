package scenic.study.designmode.behaviour_type.state.concretestate;

import scenic.study.designmode.behaviour_type.state.abstractcore.State;
import scenic.study.designmode.behaviour_type.state.abstractcore.Work;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class AfternoonState implements State {
    @Override
    public void waiteProgram(Work work) {
        if(work.hour < 17){
            System.out.println("下午工作还行");
        }else{
//            work.setState(new AfternoonState());
//            work.writeProgram();
        }
    }
}
