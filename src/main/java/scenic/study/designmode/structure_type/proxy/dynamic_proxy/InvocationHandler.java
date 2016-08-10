package scenic.study.designmode.structure_type.proxy.dynamic_proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object obj,Method m);
}
