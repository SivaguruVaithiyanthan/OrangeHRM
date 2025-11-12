package com.pages.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{
	@SuppressWarnings("null")
	public static List<Map<String , String>> ReadExcelData(String FileName , String SheetName)
	{
		List<Map<String , String>> readedDatafromExcel = null;
		
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\ConfigurationFiles\\ExcelFiles\\" + FileName);
			try (XSSFWorkbook readExcelFile = new XSSFWorkbook(fileInputStream)) 
			{
				XSSFSheet readDataFromSheet = readExcelFile.getSheet(SheetName);
				
				int totalRowsinDB = readDataFromSheet.getPhysicalNumberOfRows();
				int totalColumnsinDB = readDataFromSheet.getRow(0).getPhysicalNumberOfCells();

				for (int row = 0 ; row < totalRowsinDB ; row ++)
				{
					Map<String , String> dbReadedValues = new HashMap<String , String>();
					
					for (int columns = 0 ; columns < totalColumnsinDB ; columns ++ )
					{
						String key = readDataFromSheet.getRow(0).getCell(columns).getStringCellValue();
						String Value = readDataFromSheet.getRow(row).getCell(columns).getStringCellValue();
						
						dbReadedValues.put(key, Value);
					}
					
					readedDatafromExcel.add(dbReadedValues);		
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
		
		return readedDatafromExcel;		
	}
}
