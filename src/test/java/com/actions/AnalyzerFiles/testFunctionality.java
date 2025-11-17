package com.actions.AnalyzerFiles;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class testFunctionality implements ITestListener 
{
	public void onTestStart(ITestResult result)
	{
		System.out.println("Your Current method : " + result.getMethod().getMethodName() + " is now Started Executing.");
	}
	
	public  void onTestSuccess(ITestResult result) 
	{
		System.out.println("Your Current method : " + result.getMethod().getMethodName() + " is Successfully Executed.");
	}
}
