package com.common.actions;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pages.base.base;

public class SelectDate extends base
{
	public static LocalDate IstodayDate;
			
	public static void selectGivenDate(String Element,String Date) throws InterruptedException
	{
			
		WebElement datePickerinput = driver.findElement(By.xpath(Element));
		datePickerinput.click();
		
		IstodayDate = LocalDate.now(); //get the local Date
		LocalDate givenInputDate = LocalDate.of(Integer.parseInt(Date)); // Converting given date into Date Format.
		
		YearMonth givenMonthAndDate = date(String.valueOf(givenInputDate.getYear()) , String.valueOf(givenInputDate.getMonthValue()));
		YearMonth currentMonthAndDate = date(String.valueOf(IstodayDate.getYear()) , String.valueOf(IstodayDate.getMonthValue()));

		long monthsBetween = ChronoUnit.MONTHS.between(givenMonthAndDate, currentMonthAndDate);
		System.out.println("The Differences Between Month : " + monthsBetween);
		
		DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyy-dd-mm");
		String dateIs = givenInputDate.format(datetime);
		
		driver.findElement(By.xpath(Element)).sendKeys(dateIs);
	}
	
	public static boolean isYearGreaterOrLower(int givenInputDateYear)
	{
		if(givenInputDateYear > IstodayDate.getYear())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
    public static YearMonth date (String Year , String Month)
    {
        return YearMonth.of(Integer.parseInt(Year), Integer.parseInt(Month));
    }
}
