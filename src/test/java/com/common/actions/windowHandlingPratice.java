package com.common.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowHandlingPratice 
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public static void main(String[] args) 
	{
		driver = new ChromeDriver();	
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='example']//following-sibling::a")));
	}

}
