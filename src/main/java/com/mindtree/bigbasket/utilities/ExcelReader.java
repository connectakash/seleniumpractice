package com.mindtree.bigbasket.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public ArrayList<String> getDataExcel() throws Exception{
		ArrayList<String> myData=new ArrayList<String>();
		
		File src=new File("./testdata/items.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=null;
		
		wb= new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			System.out.println(sheet.getLastRowNum());
			myData.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		
		return myData;
	}

}
