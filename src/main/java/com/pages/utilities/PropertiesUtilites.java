package com.pages.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilites 
{
	public static Properties readpropFileData(String FileName) throws FileNotFoundException
	{
		Properties properties = new Properties();
		FileInputStream InputFile = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\" + FileName);
		try 
		{
			properties.load(InputFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return properties;
	}
}
