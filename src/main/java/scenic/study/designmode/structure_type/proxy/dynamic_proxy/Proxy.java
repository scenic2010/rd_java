package scenic.study.designmode.structure_type.proxy.dynamic_proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {

	public static void main(String[] args) {
	}

	public static Object newProxyInstance(Class<?> interface_, InvocationHandler handler) throws Exception {// JDK6

		String line = "\r\n";
		String methodStr = "";

		// for (Method m : inter.getMethods()) {
		// methodStr += "@Override " + line +
		// "public void " + m.getName() + "(){" + line +
		// "long start = System.currentTimeMillis();" +line +
		// "t."+m.getName() + "();" + line +
		// "long end = System.currentTimeMillis();" + line +
		// "System.out.println(\"TankProxy move time: \" + (end - start));"
		// +line +
		// "}";
		// }
		//
		// System.out.println(methodStr);

		for (Method m : interface_.getMethods()) {
			methodStr += "@Override " + line + 
					"public void " + m.getName() + "(){" + line + 
					"try{" + line + 
					"  java.lang.reflect.Method md = " + interface_.getName()+ ".class.getMethod(\"" + m.getName() + "\");" + line + 
					"handler.invoke(this,md);" + line + 
					"}catch(Exception e) {}" + line + 
					"}";
		}

		System.out.println(methodStr);
		
		String src = "package scenic.study.designmode.proxy.dynamic_proxy;" + line + "public class TimeProxy implements " + interface_.getName() + "{" + line
				+ InvocationHandler.class.getName() + " handler;" + line +

				"public TimeProxy(" + InvocationHandler.class.getName() + " t) {" + line + "super();" + line + "this.handler = t;" + line + "}" + line + methodStr + line + "}";

		String fileName = System.getProperty("user.dir") + "/src/scenic/study/designmode/proxy/dynamic_proxy/TimeProxy.java";
		System.out.println(fileName);
		File f = new File(fileName);
		FileWriter wr = new FileWriter(f);
		wr.write(src);
		wr.flush();
		wr.close();
		wr.close();

		JavaCompiler compler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMsg = compler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> units = fileMsg.getJavaFileObjects(fileName);
		CompilationTask task = compler.getTask(null, fileMsg, null, null, null, units);

		System.out.println(task.call());
		fileMsg.close();
		System.out.println(compler);

		URL[] urls = new URL[] { new URL("file://" + System.getProperty("user.dir") + "/src") };
		URLClassLoader u1 = new URLClassLoader(urls);
		Class<?> classz = u1.loadClass("scenic.study.designmode.proxy.dynamic_proxy.TimeProxy");
		System.out.println(classz);
		Constructor ctr = classz.getConstructor(InvocationHandler.class);
		return ctr.newInstance(handler);
	}

	
	
	// public static Object newProxyInstance(Class inter) throws
	// Exception{//JDK6 Complier API CGLib,ASK
	//
	// String line = "\r\n";
	// String methodStr = "";
	//
	// for (Method m : inter.getMethods()) {
	// methodStr += "@Override " + line +
	// "public void " + m.getName() + "(){" + line +
	// "long start = System.currentTimeMillis();" +line +
	// "t."+m.getName() + "();" + line +
	// "long end = System.currentTimeMillis();" + line +
	// "System.out.println(\"TankProxy move time: \" + (end - start));" +line +
	// "}";
	// }
	// //
	// System.out.println(methodStr);
	//
	//
	//
	//
	//
	//
	// String src =
	// "package scenic.study.designmode.proxy.dynamic_proxy;" + line +
	// "public class TimeProxy implements "+inter.getName() +"{" +line +
	// "Moveable t ;" +line +
	//
	// "public TimeProxy(Moveable t) {" +line +
	// "super();" +line +
	// "this.t = t;" +line +
	// "}" +line +
	// methodStr +line +
	// "}";
	//
	// String fileName =
	// System.getProperty("user.dir")+
	// "/src/scenic/study/designmode/proxy/dynamic_proxy/TimeProxy.java" ;
	// System.out.println(fileName);
	// File f = new File(fileName);
	// FileWriter wr = new FileWriter(f);
	// wr.write(src);
	// wr.flush();
	// wr.close();
	// wr.close();
	//
	// JavaCompiler compler = ToolProvider.getSystemJavaCompiler();
	// StandardJavaFileManager fileMsg =
	// compler.getStandardFileManager(
	// null,
	// null,
	// null);
	// Iterable<? extends JavaFileObject> units =
	// fileMsg.getJavaFileObjects(fileName);
	// CompilationTask task = compler.getTask(
	// null,
	// fileMsg,
	// null,
	// null,
	// null,
	// units);
	//
	// System.out.println(task.call());
	// fileMsg.close();
	// System.out.println(compler);
	//
	// URL[] urls = new URL[] {new URL("file://" +System.getProperty("user.dir")
	// + "/src" )};
	// URLClassLoader u1 = new URLClassLoader(urls );
	// Class<?> classz =
	// u1.loadClass("scenic.study.designmode.proxy.dynamic_proxy.TimeProxy");
	// System.out.println(classz);
	// Constructor ctr = classz.getConstructor();
	// return ctr.newInstance();
	// }

	// public static Object newProxyInstance(Class inter) throws
	// Exception{//JDK6 Complier API CGLib,ASK
	//
	// String line = "\r\n";
	// String src =
	// "package scenic.study.designmode.proxy.dynamic_proxy;" + line +
	// "public class TimeProxy implements "+inter.getName() +"{" +line +
	// "Moveable t;" +line +
	//
	// "public TimeProxy(Moveable t) {" +line +
	// "super();" +line +
	// "this.t = t;" +line +
	// "}" +line +
	//
	//
	// "@Override" +line +
	// "public void move() {" +line +
	// "long start = System.currentTimeMillis();" +line +
	// "t.move();"+
	// "long end = System.currentTimeMillis();" +line +
	//
	// "System.out.println(\"TankProxy move time: \" + (end - start));" +line +
	// "}" +line +
	//
	//
	// "@Override" +line +
	// "public void stop() {" +line +
	// "long start = System.currentTimeMillis();" +line +
	// "t.stop();"+line +
	// "long end = System.currentTimeMillis();" +line +
	// "System.out.println(\"TankProxy stop time: \" + (end - start));" +line +
	// "}" +line +
	//
	// "}";
	//
	// String fileName =
	// System.getProperty("user.dir")+
	// "/src/scenic/study/designmode/proxy/dynamic_proxy/TimeProxy.java" ;
	// System.out.println(fileName);
	// File f = new File(fileName);
	// FileWriter wr = new FileWriter(f);
	// wr.write(src);
	// wr.flush();
	// wr.close();
	// wr.close();
	//
	// JavaCompiler compler = ToolProvider.getSystemJavaCompiler();
	// StandardJavaFileManager fileMsg =
	// compler.getStandardFileManager(
	// null,
	// null,
	// null);
	// Iterable<? extends JavaFileObject> units =
	// fileMsg.getJavaFileObjects(fileName);
	// CompilationTask task = compler.getTask(
	// null,
	// fileMsg,
	// null,
	// null,
	// null,
	// units);
	//
	// System.out.println(task.call());
	// fileMsg.close();
	// System.out.println(compler);
	//
	// URL[] urls = new URL[] {new URL("file://" +System.getProperty("user.dir")
	// + "/src" )};
	// URLClassLoader u1 = new URLClassLoader(urls );
	// Class<?> classz =
	// u1.loadClass("scenic.study.designmode.proxy.dynamic_proxy.TimeProxy");
	// System.out.println(classz);
	// Constructor ctr = classz.getConstructor(Moveable.class);
	// Moveable m = (Moveable) ctr.newInstance(new Tank());
	// m.move();
	//
	// return m;
	// }

	// public static Object newProxyInstance() throws Exception{//JDK6 Complier
	// API CGLib,ASK
	//
	// String line = "\r\n";
	// String src =
	//
	// "package scenic.study.designmode.proxy.dynamic_proxy;" + line +
	// "public class TimeProxy implements Moveable{" +line +
	// "Moveable t;"+line +
	//
	// "public TimeProxy(Moveable t) {"+line +
	// "super();"+line +
	// "this.t = t;"+line +
	// "}"+line +
	//
	//
	// "@Override"+line +
	// "public void move() {"+line +
	// "long start = System.currentTimeMillis();"+line +
	// "t.move();"+
	// "long end = System.currentTimeMillis();"+line +
	//
	// "System.out.println(\"TankProxy move time: \" + (end - start));"+line +
	// "}"+line +
	//
	//
	// "@Override"+line +
	// "public void stop() {"+line +
	// "long start = System.currentTimeMillis();"+line +
	// "t.stop();"+line +
	// "long end = System.currentTimeMillis();"+line +
	// "System.out.println(\"TankProxy stop time: \" + (end - start));"+line +
	// "}"+line +
	//
	// "}";
	//
	// String fileName =
	// System.getProperty("user.dir")+
	// "/src/scenic/study/designmode/proxy/dynamic_proxy/TimeProxy.java" ;
	// System.out.println(fileName);
	// File f = new File(fileName);
	// FileWriter wr = new FileWriter(f);
	// wr.write(src);
	// wr.flush();
	// wr.close();
	// wr.close();
	//
	// JavaCompiler compler = ToolProvider.getSystemJavaCompiler();
	// StandardJavaFileManager fileMsg =
	// compler.getStandardFileManager(
	// null,
	// null,
	// null);
	// Iterable<? extends JavaFileObject> units =
	// fileMsg.getJavaFileObjects(fileName);
	// CompilationTask task = compler.getTask(
	// null,
	// fileMsg,
	// null,
	// null,
	// null,
	// units);
	//
	// System.out.println(task.call());
	// fileMsg.close();
	// System.out.println(compler);
	//
	// URL[] urls = new URL[] {new URL("file://" +System.getProperty("user.dir")
	// + "/src" )};
	// URLClassLoader u1 = new URLClassLoader(urls );
	// Class<?> classz =
	// u1.loadClass("scenic.study.designmode.proxy.dynamic_proxy.TimeProxy");
	// System.out.println(classz);
	// Constructor ctr = classz.getConstructor(Moveable.class);
	// Moveable m = (Moveable) ctr.newInstance(new Tank());
	// m.move();
	//
	// return m;
	// }
}
