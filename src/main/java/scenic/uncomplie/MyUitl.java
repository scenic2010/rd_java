package scenic.uncomplie;

import java.io.File;

public class MyUitl {

	public static String getUserDir() {
		String userDir = System.getProperty("user.dir");
		return userDir;
	}

	public static String apkPath = "C:/com/KTouchRead.apk";
	/**
	 *反编译完成之后，存放工程的目录
	 */
	public static String projectPath = getUserDir() + "/un_complie_project";

	public static void initApkPath(String apkPath) {
		MyUitl.apkPath = apkPath;
		String apkName = apkPath.substring(apkPath.lastIndexOf(File.separator) + 1, apkPath.lastIndexOf("."));
		String apkDir =  apkPath.substring(0,apkPath.lastIndexOf(File.separator));
		MyUitl.projectPath = apkDir+ "/" + apkName + "_uncomplie"  ;
	}
}
