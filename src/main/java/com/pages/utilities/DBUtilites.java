package com.pages.utilities;

import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

public class DBUtilites 
{
	public static ResultSet readedDbValues(String Query) throws FileNotFoundException, SQLException
	{
		ResultSet result = null;
		Properties dbProperties = PropertiesUtilites.readpropFileData("config.properties");
		String dbURl = dbProperties.getProperty("DBCopnnectionURL");
		String userName = dbProperties.getProperty("UserName");
		String passWord = dbProperties.getProperty("PassWord");
		
		Connection dbConnection = DriverManager.getConnection(dbURl, userName, passWord);
		result = dbConnection.createStatement().executeQuery(Query);
			
		return result;		
	}
	
	public static List<Map<String,String>> readeddatafromDB(String Query) throws FileNotFoundException, SQLException
	{
		List<Map<String, String >> RededOverallValues = new LinkedList<Map<String , String>>();
		ResultSet result = readedDbValues(Query);
		while(result.next())
		{
			Map<String , String> DBSingleValues = new HashMap<String , String>();
			for(int i = 1 ; i < result.getMetaData().getColumnCount(); i++)
			{
				String columnName = result.getMetaData().getColumnName(i);
				String ColumnValues = result.getString(i);
				
				DBSingleValues.put(columnName, ColumnValues);
			}
			RededOverallValues.add(DBSingleValues);
		}
		return RededOverallValues;
	}
}
