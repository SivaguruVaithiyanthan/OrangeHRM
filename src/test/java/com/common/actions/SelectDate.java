package com.common.actions;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.base.base;

public class SelectDate extends base
{
	public static LocalDate IstodayDate;
	
	public static void Main(String [] args)
	{
		
	}
	
	
	public void selectGivenDate(String targetYear , String targetMonth , String targetDate)
	{
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(frame);
		
		WebElement datePickerinput = driver.findElement(By.className("hasDatepicker"));
		datePickerinput.click();
		
		IstodayDate = LocalDate.now();
		LocalDate givenInputDate = LocalDate.of(Integer.parseInt(targetYear), Integer.parseInt(targetMonth), Integer.parseInt(targetDate));
		
		int yearDifferences = IstodayDate.getYear() - givenInputDate.getYear();
		
		isYearGreaterOrLower(givenInputDate.getYear());
					
	}
	
	public static boolean isYearGreaterOrLower(int givenInputDate)
	{
		if(givenInputDate > IstodayDate.getYear())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
