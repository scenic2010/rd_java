package scenic.uncomplie;

public interface Const {

	//缓存跟路径
	String cacheRootDir = FilePathUtils.getUserDir() + "/temp";
	
	String dexFile = cacheRootDir + "/classes.dex";
	
	String tempJarFile = cacheRootDir + "/temp.jar";
	
	String tempClassesDir = cacheRootDir + "/classes";
	
	String tempResDir = cacheRootDir + "/res_temp";
	
	/**
	 *存放反编译后的源文件
	 */
	String tempSrc = cacheRootDir + "/src";
}
