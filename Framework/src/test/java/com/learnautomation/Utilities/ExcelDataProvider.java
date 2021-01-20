package com.learnautomation.Utilities;


import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
				
		File src=new File("./TestData/Data.xlsx");
		
		try 
		{
			FileInputStream fin=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fin);
			
		}
		catch (Exception e) 
		{
		System.out.println("Unable to read Excel file :"+e.getMessage());	
		}
		
	}
	

	public String getStringData(int sheetIndex,int row,int column)
	{ 
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column)
	{ 
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumrericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
