package scenic.readexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestRead {
	
	
//	public void readXlsx()
	
	
	public void readerFile(){
		XSSFWorkbook wb = null;
		InputStream ifs = null;
		OutputStream ofs = null;
		String filePath = "/home/scenic/myworkspace/TestJava/trans.xlsx";
		
		// 设置要读取的文件路径
		try {
			ifs = new FileInputStream(filePath);
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new XSSFWorkbook(ifs);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			for(int i=0; i < 65536;i ++){
				XSSFRow row = sheet.getRow(i);
				System.out.println(row.getCell(0).getStringCellValue() + "  " + row.getCell(1).getStringCellValue() + 
						"  " + row.getCell(2).getStringCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile() {
		XSSFWorkbook wb = null;
		InputStream ifs = null;
		OutputStream ofs = null;
		String filePath = "/home/scenic/myworkspace/TestJava/trans.xlsx";
		try {
			// 设置要读取的文件路径
			ifs = new FileInputStream(filePath);
			// HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
			// 之后版本使用XSSFWorkbook（xlsx）
			wb = new XSSFWorkbook(ifs);

			// 获得sheet工作簿HSSFSheet
			XSSFSheet sheet = wb.getSheetAt(0);
			// 获得行HSSFRow
			XSSFRow row = sheet.getRow(6);
			// 获得行中的列，即单元格HSSFCell
			XSSFCell cell = row.getCell(0);
			// 获得单元格中的值
			String msg = cell.getStringCellValue();
			System.out.println(msg);

			row = sheet.getRow(1);
			if (row == null) {
				row = sheet.createRow(1);
			}

			cell = row.getCell(1);
			if (cell == null) {
				cell = row.createCell(1);
			}
			cell.setCellValue("This is test");
			ofs = new FileOutputStream(filePath);
			wb.write(ofs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRead tr = new TestRead();
		// tr.readFile();
//		tr.writeFile();
		tr.readerFile();
	}
}
