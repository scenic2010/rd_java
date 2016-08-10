package scenic.study.designmode.behaviour_type.state.concretestate;

import scenic.study.designmode.behaviour_type.state.abstractcore.State;
import scenic.study.designmode.behaviour_type.state.abstractcore.Work;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class NoonSate implements State {
    @Override
    public void waiteProgram(Work work) {
        if(work.hour < 13){
            System.out.println("中午没有精神");
        }else{
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}
