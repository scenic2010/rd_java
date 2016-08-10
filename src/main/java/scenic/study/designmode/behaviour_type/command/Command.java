package scenic.study.designmode.behaviour_type.command;

public interface Command {

	public void execute();
	
	/**
	 * 命令的类型
	 * @return
	 */
	public int getType();
	
}
