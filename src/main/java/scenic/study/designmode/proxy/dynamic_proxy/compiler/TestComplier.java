package scenic.study.designmode.proxy.dynamic_proxy.compiler;

import scenic.study.designmode.proxy.dynamic_proxy.Moveable;
import scenic.study.designmode.proxy.dynamic_proxy.Tank;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class TestComplier {

	public static void main(String[] args) throws Exception
	{
		String line = "\r\n";
		String src = 
			"package scenic.study.proxy.dynamic_proxy;" + line +  
			"public class TimeProxy implements Moveable{" +line + 
				"Moveable t;"+line + 

				"public TimeProxy(Moveable t) {"+line + 
					"super();"+line + 
					"this.t = t;"+line + 
				"}"+line + 


				"@Override"+line + 
				"public void move() {"+line + 
					"long start = System.currentTimeMillis();"+line + 
					"t.move();"+
					"long end = System.currentTimeMillis();"+line + 

					"System.out.println(\"TankProxy move time: \" + (end - start));"+line + 
				"}"+line + 


				"@Override"+line + 
				"public void stop() {"+line + 
					"long start = System.currentTimeMillis();"+line + 
					"t.stop();"+line + 
					"long end = System.currentTimeMillis();"+line + 
					"System.out.println(\"TankProxy stop time: \" + (end - start));"+line + 
				"}"+line + 
			
		   "}";
		
		String fileName = 
			System.getProperty("user.dir")+
			"/src/scenic/study/proxy/dynamic_proxy/TimeProxy.java" ;
		System.out.println(fileName);
		File f = new File(fileName);
		FileWriter wr = new FileWriter(f);
		wr.write(src);
		wr.flush();
		wr.close();
		wr.close();
		
		JavaCompiler compler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMsg = 
			compler.getStandardFileManager(
					null, 
					null, 
					null);
		Iterable<? extends JavaFileObject> units = fileMsg.getJavaFileObjects(fileName);
		CompilationTask task = compler.getTask(
				null, 
				fileMsg, 
				null, 
				null, 
				null, 
				units);
		
		System.out.println(task.call());
		fileMsg.close();
		System.out.println(compler);
		
		URL[] urls = new URL[] {new URL("file://" +System.getProperty("user.dir") + "/src" )};
		URLClassLoader u1 = new URLClassLoader(urls );
		Class<?> classz = u1.loadClass("scenic.study.proxy.dynamic_proxy.TimeProxy");
		System.out.println(classz);
		Constructor ctr = classz.getConstructor(Moveable.class);
		Moveable m = (Moveable) ctr.newInstance(new Tank());
		m.move();
	}
}
