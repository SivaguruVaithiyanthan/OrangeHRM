package com.pages.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenshot 
{
	public static String captureScreenShot(WebDriver driver , String nameOftheImage)
	{
		String filePathToStoreScreenShot = System.getProperty("user.dir") + "\\Screenshot\\" +  nameOftheImage + ".png";
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			File Destination = new File(filePathToStoreScreenShot);
			if(Destination.exists())
			{
				Destination.delete();
			}
			FileUtils.copyFile(source, Destination);
		} 
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return filePathToStoreScreenShot;		
	}
}
