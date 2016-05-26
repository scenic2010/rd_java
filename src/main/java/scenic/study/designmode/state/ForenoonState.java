package scenic.study.designmode.state;

/**
 * Created by liuzd2 on 2014/12/7.
 * 上午工作状态
 */
public class ForenoonState implements State {

    @Override
    public void wirteProgram(Work work) {
        if (work.hour < 12){
            System.out.println("上午工作，精神百倍");
        }else{
            work.setState(new NoonSate());
            work.wiriteProgram();
        }
    }
}
