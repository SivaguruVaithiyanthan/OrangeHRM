package com.dvms.application.utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class dbUtilities 
{
	//ResultSet = It is used to store the Raw Data in the database..
	
	public static ResultSet readDataBase(String Queries)
	{
		ResultSet results = null;
		Properties ConfigpropertiesValues = PropertiesUtilities.readData("Config.properties");	
		
		String db_URL = ConfigpropertiesValues.getProperty("db_url");
		String db_Username = ConfigpropertiesValues.getProperty("db_username");
		String db_Password = ConfigpropertiesValues.getProperty("db_password");
		
		try 
		{
			Connection connection = DriverManager.getConnection(db_URL,db_Username,db_Password);
			results.getStatement().executeQuery(Queries);			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return results;	
	}
	
	public static List<Map<String , String>> readData (String Query)
	{
		List<Map<String , String >> db_Datas = new ArrayList<Map<String , String>>();
		
		ResultSet DbResults = readDataBase(Query);
		
		try 
		{
			while(DbResults.next()) //next will Give results as true next row available , if not it will throw false
			{
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return db_Datas;	
	}
}
