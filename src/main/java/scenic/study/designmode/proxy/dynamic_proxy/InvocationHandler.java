package scenic.study.designmode.proxy.dynamic_proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object obj,Method m);
}
