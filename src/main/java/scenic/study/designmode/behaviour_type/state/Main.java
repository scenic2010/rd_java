package scenic.study.designmode.behaviour_type.state;

import scenic.study.designmode.behaviour_type.state.abstractcore.Work;

/**
 * Created by liuzd2 on 2014/12/7.
 */
public class Main {
    public static void main(String args[]){
        Work work = new Work();
        work.hour = 6;
        work.writeProgram();
    }




}
