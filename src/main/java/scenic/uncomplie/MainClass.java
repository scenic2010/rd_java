package scenic.uncomplie;

import com.nova.scenic.projectlibs.util.StringUtil;

import org.apache.commons.io.FileUtils;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import brut.androlib.ApkDecoder;

public class MainClass extends JFrame implements DropTargetListener {
	
	public static final boolean SHOW_DEBUG_MSG = false;

	private static TextArea ta = new TextArea();

	private static String cmds[] = null;
	private static int cmdIndex;
	private static String apkPath="/Users/scenic/tmp/小米智能家庭_3.5.9_60515.apk";

	public static void main(String[] args) {
		cmds = args;
		String firstCmd = nextCmd();
		MainClass instance = new MainClass();
		if(firstCmd == null){
			instance.doUncouple(apkPath);
			return;
		}
		switch(cmd.valueOf(firstCmd)){
		case decompile_apk:
			try {
				instance.doUncouple(nextCmd());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case decompile_java_jar:
			instance.javaJar2Src(nextCmd());
			break;
		case show_gui:
			new MainClass().run();
			break;
		case decompile_dex_jar:
			instance.dexJar2Src(nextCmd());
			break;
		}
		
	}

	public void run(){
		new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
		setLayout(new BorderLayout());
		JTextArea lb = new JTextArea();
		lb.setEditable(false);
		lb.setText("      说明：\n" +
				"      直接把apk包拖到该控件上既可完成反编译的工作\n" +
				"      要确保把jad.exe配置到环境变量中才可以正常的编译");
		add(lb,BorderLayout.NORTH);
		//"在使用之前请确保把jad.exe配置到环境变量当中去";
		ta.setFocusable(false);
		add(ta);
		setTitle("android反编译");
		setLocation(400, 400);
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void javaJar2Src(String jarPath){
		
		String outputDirectory = FilePathUtils.getDefaultClassPathByJar(jarPath);
		try {
			ZipUtil.unzip(jarPath, outputDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String srcFile = FilePathUtils.getDefaultSrcPathByClass(outputDirectory);
		try {
			UnComplieClass.executeOlDoUncompile(outputDirectory, srcFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		p("src file is " + srcFile);
	}
	
	
	public void dexJar2Src(String dexJarPath){
		try {
			String fileSuffix = StringUtil.getFileSuffix(dexJarPath);
			if(fileSuffix.equals("jar")){
				String dexFolderPath = dexJarPath.substring(0, dexJarPath.lastIndexOf("."+fileSuffix)) + "";
				
				System.out.println("dexJarPath " + dexJarPath + "\n"+
				"dexFolderPath " + dexFolderPath + "\n" +
				"file suffix " + fileSuffix);
				//dexJarPath /home/scenic/Documents/clear/pkg_uncomplie/assets/RemoteTools.jar
				//dexFolderPath /home/scenic/Documents/clear/pkg_uncomplie/assets/RemoteTools.
				//解压dexjar
				ZipUtil.unzip(dexJarPath, dexFolderPath);
				
				
				String dexpath = dexFolderPath + "/classes.dex";
				String destJarPath = dexFolderPath + "/dex_class.jar";
				
				
				System.out.println("dexpath " + dexpath + "\n"+
						"destJarPath " + destJarPath );
//				dexpath /home/scenic/Documents/clear/pkg_uncomplie/assets/RemoteTools./classes.dex
//				distJarPath /home/scenic/Documents/clear/pkg_uncomplie/assets/RemoteTools./dex_class.jar
				dex2Jar(dexpath, destJarPath);
				
				String destClassFolder = destJarPath.substring(0, destJarPath.lastIndexOf(".jar"));
				String classStrFolder = dexFolderPath + "/src";
				System.out.println("destClassFolder " + destClassFolder + "\n" +
									"classStrFolder " + classStrFolder
						);
				
				ZipUtil.unzip(destJarPath, destClassFolder);
				
				try {
					UnComplieClass.executeOlDoUncompile(destClassFolder, classStrFolder);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String doUncouple(String apkPath) {
		FilePathUtils.getInstance().initApkPath(apkPath);
		if(!clearCache()){
			return null;
		}
		
		// 解压apk
		p("正在解压apk...");
		try {
			p("unzip " + FilePathUtils.getInstance().apkPath + " to " + Const.cacheRootDir);
			ZipUtil.unzip(FilePathUtils.getInstance().apkPath, Const.cacheRootDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dex2Jar(Const.dexFile,Const.tempJarFile);
		
		p("copy jar");
		CreateProject.copyJarFile();
		
		try {
			createResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		p("正在解压jar");
		// 解压jar
		try {
			ZipUtil.unzip(Const.tempJarFile, Const.tempClassesDir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		p("调用jad反编译class");
		try {
			UnComplieClass.unComplie();
		} catch (Exception e) {
			e.printStackTrace();
		}

		p("复制src");
		CreateProject.copySrc();
		
		
		p("编译工作完成");
//		FileUtils.deleteQuietly(cacheFile);
//		FileUtils.deleteDirectory(cacheFile);

		clearCache();
		return FilePathUtils.getInstance().projectPath;
	}

	

	private void dex2Jar(String dexfile, String tempjarfile) {
		p("正在反编译dex生成jar");
		try {
			UnComplieClass.dex2Jar(dexfile, tempjarfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean clearCache() {
		p("正在清除缓存...");
		File cacheFile = new File(Const.cacheRootDir);
		p("cacheRootDir " + Const.cacheRootDir);
		if(cacheFile.exists() && !FileUtils.deleteQuietly(cacheFile)){
			p("缓存清除失败,请手动删除temp文件夹");
			return false;
		}
		return true;
	}

	private void createResource() throws Exception {
		p("正在生成xml...");
		apkToXml(FilePathUtils.getInstance().apkPath, Const.tempResDir);
		
		p("复制res");
		CreateProject.copyRes();
		
		p("复制assets");
		CreateProject.copyAssets();
		
		p("复制 mainfest");
		CreateProject.copyMainFest();
	}

	public static void p(String string) {	
		ta.append(string + "\n");
		System.out.println(string);
	}

	private void apkToXml(String path, String toPath) throws Exception {
		ApkDecoder decoder = new ApkDecoder();
		int i;
		String args[] = {"-d","-f" ,"-s", path, toPath };
		for (i = 0; i < args.length; i++) {
			String opt = args[i];
			if (!opt.startsWith("-"))
				break;
			if ("-s".equals(opt) || "--no-src".equals(opt)) {
				decoder.setDecodeSources((short) 0);
				continue;
			}
			if ("-d".equals(opt) || "--debug".equals(opt)) {
				decoder.setDebugMode(true);
				continue;
			}
			if ("-t".equals(opt) || "--frame-tag".equals(opt)) {
				if (++i >= args.length)
					throw new InvalidArgsError();
				decoder.setFrameworkTag(args[i]);
				continue;
			}
			if ("-f".equals(opt) || "--force".equals(opt)) {
				decoder.setForceDelete(true);
				continue;
			}
			if ("-r".equals(opt) || "--no-res".equals(opt)) {
				decoder.setDecodeResources((short) 256);
				continue;
			}
			if ("--keep-broken-res".equals(opt))
				decoder.setKeepBrokenResources(true);
			else
				throw new InvalidArgsError();
		}

		String outName = null;
		if (args.length == i + 2)
			outName = args[i + 1];
		else if (args.length == i + 1) {
			outName = args[i];
			outName = outName.endsWith(".apk") ? outName.substring(0, outName.length() - 4) : (new StringBuilder()).append(outName).append(".out").toString();
			outName = (new File(outName)).getName();
		} else {
			throw new InvalidArgsError();
		}
		File outDir = new File(outName);
		decoder.setOutDir(outDir);
		decoder.setApkFile(new File(args[i]));
		
		try {
			decoder.decode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("res out file is " + outDir.getAbsolutePath());
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {

	}

	@Override
	public void dragExit(DropTargetEvent dte) {

	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {

	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try {
			if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
				dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
				List list = (List) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					final File f = (File) iterator.next();

					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								doUncouple(f.getAbsolutePath());
							} catch (Exception e) {
								p(e.getMessage());
								e.printStackTrace();
								
							}
						}
					}).start();
				
				}
				dtde.dropComplete(true);

			} else {
				dtde.rejectDrop();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (UnsupportedFlavorException ufe) {
			ufe.printStackTrace();
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {

	}

	
	public static String nextCmd(){
		if(cmds == null || cmds.length == 0){
			return null;
		}
		return cmds[cmdIndex++];
	}
	
	public enum cmd{
		show_gui,
		decompile_apk,
		decompile_java_jar,
		decompile_dex_jar,
	}
	
}
