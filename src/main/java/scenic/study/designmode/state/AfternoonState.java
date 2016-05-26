package scenic.study.designmode.state;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class AfternoonState implements State {
    @Override
    public void wirteProgram(Work work) {
        if(work.hour < 17){
            System.out.println("下午工作还行");
        }else{
//            work.setState(new AfternoonState());
//            work.wiriteProgram();
        }
    }
}
