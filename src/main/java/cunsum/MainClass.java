package cunsum;

import com.nova.scenic.projectlibs.util.StringUtil;

import java.io.File;

import scenic.readerexcel.XlsxReader;
import scenic.readerexcel.XlsxReader.OnReadXlsxHelper;

public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 new MainClass().run();
		
	}


	private void run() {
		System.out.println("current path " + StringUtil.str_current_path);
		String targetPath = StringUtil.str_current_path + "\\excel";
		System.out.println("Target path " +targetPath );
		File file  = new File(targetPath);
		File fileName[] = file.listFiles();
		System.out.println(
				StringUtil.arrayToList(fileName)
				);
		
		CheckResult result = getExcelFileNumber(fileName);
		if(result.number > 1){
			System.err.println("xlsx 文件大于1个，请只把需要的文件放到 excel中");
			return;
		}
		
		
		XlsxReader reader = new XlsxReader(result.lastMatchFile.getAbsolutePath());
		System.out.println(reader.showAll(3, new OnReadXlsxHelper() {
			@Override
			public void onReadLine(String arg0) {
//				System.out.println(arg0);
			}
		}));
		
	}

	
	private CheckResult getExcelFileNumber(File[] files) {
		int number = 0;
		CheckResult result = new CheckResult();
		for (File file : files) {
			String suffix = StringUtil.getFileSuffix(file.getAbsolutePath());
//			System.out.println(suffix);
			if(suffix.equals("xlsx")){
				number++;
				result.lastMatchFile = file;
			}
		}
		result.number = number;
		return result;
	}

	
	class CheckResult {
		int number;
		File lastMatchFile;
	}
	
}
