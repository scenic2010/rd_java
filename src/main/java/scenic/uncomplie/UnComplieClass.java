package scenic.uncomplie;

import java.io.*;

public class UnComplieClass {

	private static boolean isWindow = false;
	private static boolean isLinux = true;

	private static JavaShellUtil execute = new JavaShellUtil();
	public static void unComplie() throws Exception {
//		executeNewUnCompile();
		 executeOlDoUncompile(Const.tempClassesDir,Const.tempSrc);
	}

	public static void dex2Jar(String dexpath , String distJarPath) throws IOException {
		System.out.println("正在反编译dex生成jar");
		// 反编译dex成jar
		File dex = new File(dexpath);
		File distFile = new File(distJarPath);
		com.googlecode.dex2jar.v3.Main.doFile(dex, distFile);
	}
	
	protected static void executeNewUnCompile() throws IOException, InterruptedException {
		System.out.println("正在调用jad反编译class文件");
		String cmdStr = null;
		// 创建 src
		
		if (isWindow) {
			cmdStr = "jad -o -r -sjava -d" + Const.tempSrc + " " + Const.tempClassesDir + "/**/*.class";
		} else if (isLinux) {
			cmdStr = "jad -o -r -sjava -d" + Const.tempSrc + " '" + Const.tempClassesDir + "/**/*.class" + "'";
			// cmdStr = "ls";
		} else {
			System.out.println("not support os");
			return;
		}
		
		System.out.println("the execute cmd " + cmdStr);
		
		File classPathFile = new File(Const.tempClassesDir);
		File[] allClassFiles = classPathFile.listFiles();
		execute(allClassFiles);
	}

	/**
	 * @param allClassFiles
	 * @throws IOException 
	 */
	protected static void execute(File[] allClassFiles) throws IOException {
		for(int i = 0; i < allClassFiles.length; i++){
			File f = allClassFiles[i];
			if(f.isDirectory()){
				String cmdStr = "jad -o -r -sjava -d" + Const.tempSrc + " " + f.getAbsolutePath() + "/*.class";
				execute(f.listFiles());
			}else{
				String path = f.getAbsolutePath();
//				Runtime.getRuntime().exec("");
				if(!path.contains("$") && !path.contains("google") && !path.contains("jboss")){
					execute.executeLocalCmd("jad -d/home/scenic/download -o -sjava " + f.getAbsolutePath());
//					System.out.println(path);
				}else{
//					System.err.println(path);
				}
			}
		}
	}

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	protected static void executeOlDoUncompile(String classPath,String srcPath) throws IOException, InterruptedException {
		// String[] path = new String[] { "path=" + userDir + "/XJad" };
		// Process process = Runtime.getRuntime().exec("cmd /c path " + jadDir);
		System.out.println("正在调用jad反编译class文件");
		String cmdStr = null;
		if (isWindow) {
			cmdStr = "jad -o -r -sjava -d" + srcPath + " " + classPath + "/**/*.class";
		} else if (isLinux) {
			cmdStr = "jad -o -r -sjava -d" + srcPath + " '" + classPath + "/**/*.class" + "'";
		} else {
			System.out.println("not support os");
			return;
		}

		System.out.println("cmd is \n " + cmdStr + "\n如果出错可以手动输入命令行中" );
		MainClass.p("execut cmd is :" + cmdStr);
		execute.executeLocalCmd(cmdStr);
	}

	
	
	private static void showErrorMessage(InputStream errorStream) throws IOException {
		String temp = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(errorStream));
		while ((temp = br.readLine()) != null) {
			System.out.println(temp);
		}
	}
}
