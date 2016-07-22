package scenic.readerexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class XlsxReader2 {

	private FileInputStream mFileInputStream;
	private XSSFWorkbook mXSSFWorkbook;

	private String spliteFlag = ":";
	
	public XlsxReader2(String filePath) {
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
	
	public String showAll(int colCount){
		XSSFSheet sheet = getSheet(0);
		int rownum = 0;
		XSSFRow row ;
		
		StringBuilder sb = new StringBuilder();
		while( (row = sheet.getRow(rownum )) != null){
			rownum++;
			for(int i =0 ; i < colCount; i++){
				XSSFCell cell = row.getCell(i);
				sb.append(cell.getStringCellValue());
				if(i < colCount - 1){
					sb.append(spliteFlag);
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	protected String readerCell(XSSFRow row,int cellNum){
		XSSFCell cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	
	public XSSFSheet getSheet(int index){
		XSSFSheet sheet = mXSSFWorkbook.getSheetAt(index);
		return sheet;
	}
	
	
//	public void reader(int row, int col) {
//		// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
//		// 之后版本使用XSSFWorkbook（xlsx）
//		XSSFWorkbook mXSSFWorkbook = new XSSFWorkbook(mFileInputStream);
//
//		XSSFSheet sheet = mXSSFWorkbook.getSheetAt(0);
//		for (int i = 0; i < 65536; i++) {
//			XSSFRow row = sheet.getRow(i);
//			System.out.println(row.getCell(0).getStringCellValue() + "  " + row.getCell(1).getStringCellValue() + "  " + row.getCell(2).getStringCellValue());
//		}
//	}

	
}
