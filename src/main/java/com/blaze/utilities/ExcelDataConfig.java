
package com.blaze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * 
 * @author WA
 * 
 */
public class ExcelDataConfig{
	
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public File src;
	public FileInputStream fileInputStream;
	
	public static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();

	//class constructor - excel file path
	public ExcelDataConfig(String excelPath) { 
		try {
			src = new File(excelPath); 
			fileInputStream = new FileInputStream(src);
			wb = new XSSFWorkbook(fileInputStream);
	
			wb.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//here sheet#, row number & column number
	public String getData(int SheetNumber, int rownum, int cellnum) {
		sheet = wb.getSheetAt(SheetNumber);
		DataFormatter formatter = new DataFormatter();
		
		String value = formatter.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
		return value;
	}

	//get 'total rows' from sheet
	public int getRowCount(int SheetNumber) {
		sheet = wb.getSheetAt(SheetNumber);
		int rowCount = sheet.getLastRowNum();
		return (rowCount + 1);
	}

	//get 'total column(s)' from sheet
	public int getRowColumnCount(int SheetNumber) {
		
		int columnCount =0;
		sheet = wb.getSheetAt(SheetNumber);
		Row row= sheet.getRow(0);
		columnCount = row.getLastCellNum();
		return columnCount;
	}


}
