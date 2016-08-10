package scenic.study.designmode.behaviour_type.command;

public abstract class BaseCommand implements Command{

	/**
	 * 接收这个命令
	 */
	protected CmdReceiver mReceiver;
	
	public BaseCommand(CmdReceiver receiver) {
		// TODO Auto-generated constructor stub
		mReceiver = receiver;
	}
}
