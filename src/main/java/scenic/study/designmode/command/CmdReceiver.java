package scenic.study.designmode.command;
/**
 * Receiver是被调用者（士兵），烤串的师傅
 * 命令的接受着，知道如何去执行一个与请求相关的操作
 * @author scenic
 *
 */
public interface CmdReceiver {
	void receiver();
}
