package scenic.uncomplie;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CreateProject {

	public static void copySrc() {
		copy(Const.tempSrc, FilePathUtils.getInstance().projectPath + "/src");
	}

	public static void copyRes() {
		copy(new File(Const.tempResDir + "/res" ), new File(FilePathUtils.getInstance().projectPath + "/res"));
	}
	
	public static void copyAssets() {
		copy(new File(Const.tempResDir + "/assets" ), new File(FilePathUtils.getInstance().projectPath + "/assets"));
	}
	
	public static void copyMainFest() {
		try {
			FileUtils.copyFile(new File(Const.tempResDir + "/AndroidManifest.xml"),
					new File( FilePathUtils.getInstance().projectPath+"/AndroidManifest.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyJarFile() {
		try {
			FileUtils.copyFile(new File(Const.tempJarFile), 
					new File(FilePathUtils.getInstance().projectPath + "/class.jar"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copy(File from, File des) {
		try {
			FileUtils.copyDirectory(from,des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void copy(String tempsrc, String dest) {
		copy(new File(tempsrc), new File(dest));
	}

	

}
