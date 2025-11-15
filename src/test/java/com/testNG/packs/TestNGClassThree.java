package com.testNG.packs;


import com.pages.base.base;
import com.pages.locators.loginPage;
import com.pages.utilities.ExcelUtilities;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGClassThree extends base
{
	public static int count = 0;
	@DataProvider(name = "loginData")
	public Object[][] providedLoginData()
	{		
		return new Object[][]
		{
			{"sivagru@gmail.com" , "Test@123"},
			{"Deepak@gmail.com" , "Test@123"},
			{"Vijaykumar@gmail.com" , "Test@123"}
		};
	}
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		System.out.println("Before Suite: Running once before the test suite.");
	}
	
		   @BeforeTest(alwaysRun = true)
		   public void beforeTest()
		   {	   
			   System.out.println("Before Test: Running once before the test suite.");
		   }
	              @BeforeClass(alwaysRun = true)
	              public void beforeClass()
	              {
	            	  System.out.println("Before Class: Running once before the first test method.");             	     
	              }
	              
	                    @BeforeMethod(alwaysRun = true)
	                    public void beforeMethod()
	                    {
	                    	System.out.println("Chrome Browser initialzed Successfully..");  
	                    }
	                    
	                         @Test(priority = 1 , groups = {"Regression"})
	                         public void BcheckLoginFunctionality()
	                         {
	                        	 System.out.println("Check Login Functioinality B..");              	
	                         }
	                         
	                         @Test(priority = 0, groups = {"Regression" , "Smoke"}, dependsOnMethods = {"BcheckLoginFunctionality"})
	                         public void AcheckLoginFunctionality()
	                         {
	                        	 System.out.println("Check Login Functioinality A..");              	
	                         }
	                         
	                         @Test(priority = 2 , groups = {"Regression" , "Sanity"} , dependsOnMethods = {"AcheckLoginFunctionality"} )
	                         public void CcheckLoginFunctionality()
	                         {
	                        	 System.out.println("Check Login Functioinality Adeiiiiiii..");              	
	                         }
	
	                         @Test(priority = 3 , dataProvider = "loginData", groups = {"Regression" , "Unit"} , enabled = true)
	                         public void CheckUserDetails(String Username , String password)
	                         {
	                        	 System.out.println("Check Login Functioinality Username :" + Username + "Password :" + password);              	
	                         }
	                         
	                         @Test
	                         @Parameters({"browser", "URL"})
	                         public void driverWithURL(String BrowserName , String URL)
	                         {
	                        	 System.out.println("Browsername :" + BrowserName);
	                        	 System.out.println("PageURL :" + URL);
	                         }
	                         
	                         @Test( invocationCount = 5)
	                         public void loginPageRegression()
	                         {
	                        	 count++;
	                        	 System.out.println("Login page Tested at : " + count + " Times");
	                         }
	                         
	                         @Test( invocationCount = 5 , timeOut = 3000)
	                         @Parameters( {"Name" , "EmployeeID" , "Password"} )
	                         public void loginPage( String userName , String passWord , String employeeID) throws InterruptedException
	                         {
	                        	 System.out.println("User of : " + userName + " login Successfully");
	                        	 Thread.sleep(5000);
	                        	 System.out.println("TempToken Created : " + passWord.concat(employeeID) );
	                         }	                         
	
	                    @AfterMethod(alwaysRun = true)
	                    public void afterMethod()
	                    {
	                    	System.out.println("Chrome Browser closed Successfully..");  
	                    }
	                    
	                @AfterClass(alwaysRun = true)
	                public void AfterClass()
	                {
	                	System.out.println("Executing @AfterClass: Performing cleanup for MyTestClass..");
	                }
	
	      @AfterTest(alwaysRun = true)
	      public void bafterTest()
		   {
	    	  System.out.println("Executing @AfterTest: Performing cleanup for MyTest.");
		   }
	      
	@AfterSuite(alwaysRun = true)
	public void afterSuite()
	{
		System.out.println("After Suite: Running once After the test suite.");
	}
	
}
