package scenic.study.designmode.command;

public interface Command {

	public void execute();
	
	/**
	 * 命令的类型
	 * @return
	 */
	public int getType();
	
}
