package scenic.study.designmode.command;



public class MyCommand extends BaseCommand {
	
	public MyCommand(CmdReceiver receiver) {
		super(receiver);
	}
	
	@Override
	public void execute() {
		System.out.println("execute cmd finish ");
		mReceiver.receiver();
	}

	@Override
	public int getType() {
		return 0;
	}

}
