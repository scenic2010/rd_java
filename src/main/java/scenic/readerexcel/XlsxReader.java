package scenic.readerexcel;

import com.lenovo.nova.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class XlsxReader {

	private FileInputStream mFileInputStream;
	private XSSFWorkbook mXSSFWorkbook;

	private String spliteFlag = ":";



	public XlsxReader(String filePath) {
		// 设置要读取的文件路径
		try {
			mFileInputStream = new FileInputStream(filePath);
//			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
//			// 之后版本使用XSSFWorkbook（xlsx）
			mXSSFWorkbook = new XSSFWorkbook(mFileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public String showAll(int colCount,OnReadXlsxHelper helper){
		XSSFSheet sheet = getSheet(0);
		int rownum = 0;
		XSSFRow row ;
		StringBuffer sb = new StringBuffer();
		while( (row = sheet.getRow(rownum )) != null){
			rownum++;
			String line = readOneLineCell(colCount, row);
			sb.append(line);
			sb.append(System.getProperty("line.separator"));
			if(helper != null){
				helper.onReadLine(line);
			}
		}
		return sb.toString();
	}
	
	StringBuilder mStringBuilder = new StringBuilder();
	private String readOneLineCell(int colCount, XSSFRow xssrow) {
		mStringBuilder.delete(0, mStringBuilder.length());
		if(colCount < 0){
			//自动检测长度
			int row = 0;
			while(true){
				XSSFCell cell = xssrow.getCell(row);
				row++;
				if(cell != null){
					String cellValue = cell.getStringCellValue(); 
					mStringBuilder.append(cellValue);
					mStringBuilder.append(spliteFlag);
				}else{
					mStringBuilder.deleteCharAt(mStringBuilder.length() - 1);
					break;
				}
			}
		}else{
			for(int i =0 ; i < colCount; i++){
				XSSFCell cell = xssrow.getCell(i);
				if(cell != null){
					String cellValue = cell.getStringCellValue(); 
					mStringBuilder.append(cellValue);
					if(i < colCount - 1){
						mStringBuilder.append(spliteFlag);
					}
				}
			}
		}
		
		return mStringBuilder.toString();
	}
	protected String readerCell(XSSFRow row,int cellNum){
		XSSFCell cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	
	public XSSFSheet getSheet(int index){
		XSSFSheet sheet = mXSSFWorkbook.getSheetAt(index);
		return sheet;
	}
	
	

	public interface OnReadXlsxHelper{
		void onReadLine(String line);
	}
	
	
	public static void main(String[] args) {
		String filePath = "D:\\迅雷下载\\ddd\\VDtest_xiaozTV_2014_5_29.xlsx";
		String str = new XlsxReader(filePath).showAll(-1,new OnReadXlsxHelper() {
			
			@Override
			public void onReadLine(String line) {
				System.out.println(line);
			}
		});
		
		String suffix = StringUtil.getFileSuffix(filePath);
		if("xlsx".equals(suffix)){
			
		}else{
			
		}
//		try {
//			FileOutputStream out = new FileOutputStream(new File("all.txt"));
//			out.write(str.getBytes());
//			out.flush();
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
}
