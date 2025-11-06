package com.dvms.application.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{
	public static String [][] readExcelData (String FileName , String SheetName)
	{
		String [][] readedExcelDatas = null;
		
		try 
		{
			FileInputStream files = new FileInputStream(System.getProperty("user.dir")+"\\ExcelsToAccessData\\"+FileName);
			
			XSSFWorkbook ExcelFile = new XSSFWorkbook(files); // To read the Excel File...
			
			XSSFSheet workSheet = ExcelFile.getSheet(SheetName); // To read the Data's from the Given Sheet name.
			
			int totalNumberofRows = workSheet.getPhysicalNumberOfRows(); // it will count the total number of Rows
			
			int totalNumberofColumns = workSheet.getRow(0).getPhysicalNumberOfCells(); // it will count the total number of Columns in the first Row
			
			readedExcelDatas = new String [totalNumberofRows] [totalNumberofColumns];
			
			for ( int row = 0 ; row < totalNumberofRows ; row++ )
			{
				for ( int Column = 0 ; Column < totalNumberofColumns ; Column++ )
				{				
					readedExcelDatas [row][Column] = workSheet.getRow(row).getCell(Column).getStringCellValue(); // Get the Column Values
				}
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return readedExcelDatas;
		
	}
}
