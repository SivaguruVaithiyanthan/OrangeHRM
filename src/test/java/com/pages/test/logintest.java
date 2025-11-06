package com.pages.test;
import com.pages.base.base;
import com.pages.locators.loginPage;
import com.pages.utilities.ExcelUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class logintest extends base
{

	loginPage loginObjects;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	@BeforeClass
	public void setUp()
	{
	   initializeWebBrowser();	   
	   loginObjects = new loginPage(driver);
	}
	
	@BeforeTest()
	private static List<Map<String , String>> dataBaseOutPut()
	{
		List<Map<String , String>> valuesOfDB = ExcelUtilities.ReadExcelData("Loginpasswords.xlsx", "LoginPageCredentials");	
		return valuesOfDB;		
	}
	
	@Test(priority = 1)
	public void ValidLogin()
	{		
		for (Map<String, String> Values : dataBaseOutPut())
		{
			String userName = Values.get("userName");
			String passWord = Values.get("passWord");
		    loginObjects.LoginValidation(userName, passWord);
	   }
	}
	
	@Test(priority = 2)
	public void inValidLogin()
	{
		loginObjects.LoginValidation("sivaguru@devcare.biz", "Siva@1234");
	}
	
	@Test(priority = 3)
	public void DasboardValidation()
	{
		loginObjects = new loginPage(driver);
		String dasboardText = loginObjects.DashBoard.getText();
		String expectedDashBoardText = "DasnBoard";	
		Assert.assertEquals(dasboardText, expectedDashBoardText);	
		
		WebElement navMenu = driver.findElement(By.xpath("//ul[contains(@class,'oxd-main-menu')]"));
		List<WebElement> navigationSubMenus = navMenu.findElements(By.tagName("li"));
		for (WebElement element : navigationSubMenus)
		{
			System.out.println("Navigation Menus : " + element.getText());
		}
	}
	
	@Test(priority = 4)
	public void gridActions()
	{
		
	}
	
}
