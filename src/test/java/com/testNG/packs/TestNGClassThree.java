package com.testNG.packs;

import com.pages.base.base;
import com.pages.utilities.ExcelUtilities;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClassThree extends base
{
	public static WebDriverWait wait = null;
	public static List<Map<String , String>> valuesOfReadedExcel = null;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite: Running once before the test suite.");
	}
	
		   @BeforeTest
		   public void beforeTest()
		   {
           	 valuesOfReadedExcel = ExcelUtilities.ReadExcelData("CommonAccess.xlsx", "AddEmployeeDetails");
		   }
	
	              @BeforeClass
	              public void beforeClass()
	              {
	            	  System.out.println("Before Class: Running once before the first test method."); 
	            	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            	  
	              }
	              
	                    @BeforeMethod
	                    public void beforeMethod()
	                    {
	                    	initializeWebBrowser();	 
	                    	System.out.println("Chrome Browser initialzed Successfully");  
	                    }
	                    
	                         @Test
	                         public void checkLoginFunctionality()
	                         {
	                        	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	                        	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
	                        	 
	                        	 
	                         }
	
	
	
	
	
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite: Running once After the test suite.");
	}
	
	
}
