package com.common.actions;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowHandlingPratice 
{
	public static WebDriver driver = null;


	public static void main(String[] args) throws InterruptedException 
	{
		driver = new ChromeDriver();	
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
		String Element = "//div[@class='example']//following-sibling::a";
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Element)));
		
		for(int i = 0 ; i < 5 ; i ++)
		{
			driver.findElement(By.xpath(Element)).click();
			Thread.sleep(2000);
		}
		
		String parentWindowId = driver.getWindowHandle();
		
		Set<String> windowsIds = driver.getWindowHandles();
		for(String ID : windowsIds)
		{
			if(!ID.equals(parentWindowId))
			{
				driver.switchTo().window(parentWindowId);
				System.out.println("You are in the Window of " + ID);
			}
		}
		
		driver.quit();
	}

}
