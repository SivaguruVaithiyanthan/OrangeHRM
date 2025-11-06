package com.pages.base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base 
{
	public static WebDriver driver;
	
	public static void initializeWebBrowser()
	{
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	
	public static void webBrowserClose()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
