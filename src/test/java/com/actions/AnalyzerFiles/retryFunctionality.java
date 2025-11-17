package com.actions.AnalyzerFiles;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryFunctionality implements IRetryAnalyzer
{
	int retryCount = 0;
	public static int maximumCount = 3;

	@Override
	public boolean retry(ITestResult result)
	{
		if(!result.isSuccess())
		{
			if(retryCount <  maximumCount)
			{
				retryCount++;
				return true;
			}
		}
		return false;
	}

}
