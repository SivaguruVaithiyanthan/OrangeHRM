package com.testNG.packs;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGClassOne 
{
	@BeforeSuite
	public void StartingProject()
	{
		System.out.println("Starrting the Project");
	}
	
	@AfterSuite
	public void EndingProject()
	{
		System.out.println("Ending the Project");
	}
	
	@BeforeTest
	public void intializeBrowser()
	{
		System.out.println("Initialize the Browser");
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		System.out.println("Close the Browser");
	}
	
	@BeforeMethod
	public void deleteCookies()
	{
		System.out.println("Cookies Deleted");
	}
	
	@AfterMethod
	public void SomethingNew()
	{
		System.out.println("SomeThing Missed or Added");
	}
}
