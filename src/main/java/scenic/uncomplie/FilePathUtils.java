package scenic.uncomplie;

import java.io.File;

public class FilePathUtils {

	public static FilePathUtils mInstance = new FilePathUtils();
	
	public static String getUserDir() {
		String userDir = System.getProperty("user.dir");
		return userDir;
	}
	
	public static FilePathUtils getInstance(){
		return mInstance;
	}
	
	/**
	 * 被编译的apk的path
	 */
	public  String apkPath = "C:/com/KTouchRead.apk";
	/**
	 *反编译完成之后，存放工程的目录
	 */
	public String projectPath = getUserDir() + "/un_complie_project";
	
	
	public  void initApkPath(String apkPath) {
		this.apkPath = apkPath;
		System.out.println("apk path is " + apkPath);
		String apkName = apkPath.substring(apkPath.lastIndexOf(File.separator) + 1, apkPath.lastIndexOf("."));
		System.out.println("apk name is " + apkName);
		
		String apkDir =  apkPath.substring(0,apkPath.lastIndexOf(File.separator));
		System.out.println("apkDir " + apkDir + " file.separator " + File.separator);
		projectPath = apkDir+ "/" + apkName + "_uncomplie"  ;
		
	}
	
	
	public static String getDefaultClassPathByJar(String jarPath){
		String classFolder = jarPath.substring(0, jarPath.lastIndexOf(".jar"));
		return classFolder;
	}
	
	public static String getDefaultSrcPathByClass(String classPath){
		return getDefaultClassPathByJar(classPath+".jar") +"_src";
	}
	
}
