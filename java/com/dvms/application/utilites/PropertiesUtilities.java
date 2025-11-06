package com.dvms.application.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities 
{
	public static Properties readData(String propertiesValues)
	{
		Properties properties = new Properties();
		
		try 
		{
			FileInputStream Files = new FileInputStream(System.getProperty("user.dir") + "\\ConfigurationFiles\\" + propertiesValues);
			properties.load(Files);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return properties;
	}
}
