package scenic.study.designmode.responsibility.common;

/**
 * 处理请求的统一接口
 * @author scenic
 *
 */
public interface Manager {
	
	void doDealRequest(Request request, Response respons);
	
}
