package scenic.study.designmode.command;

import java.util.ArrayList;
import java.util.List;


/**
 * 是调用者 (服务员)
 * @author scenic
 *Invoker 命令的调用操作者，或者命令的请求着
 */
public class Waiter {

	private List<Command> mCommands = new ArrayList<Command>();
	
	public Waiter() {
		
	}
	
	public void addComman(Command command){
		if(command.getType() == 0){
			System.out.println("在次环境下不支持这个命令");
			return;
		}
		
		mCommands.add(command);
	}
	
	public void notifyExecuteCommand(){
		for (Command command : mCommands) {
			command.execute();
		}
	}
}
