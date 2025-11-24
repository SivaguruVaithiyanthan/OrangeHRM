package com.pages.test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.base.base;
import com.pages.locators.loginPage;
import com.pages.locators.AddEmployee;
import com.pages.utilities.ExcelUtilities;
import com.common.actions.*;

public class AddEmployeeDetails extends base
{
	loginPage loginObjects;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	
	public void AddEmployee() throws InterruptedException 
	{
		loginObjects = new loginPage(driver);
		List<Map<String, String>> valuesOfReadedExcel = ExcelUtilities.ReadExcelData("CommonAccess.xlsx","AddEmployee");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(loginObjects.navMenuPIM)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginObjects.addEmployee)).click();

		for (Map<String, String> Values : valuesOfReadedExcel)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) loginObjects.firstName));

			String firstName = Values.get("FirstName");
			String lastName = Values.get("LastName");
			String empID = Values.get("EmpID");

			loginObjects.firstName.sendKeys(firstName);
			loginObjects.lastName.sendKeys(lastName);
			loginObjects.empID.sendKeys(empID);

			wait.until(ExpectedConditions.elementToBeClickable(loginObjects.saveButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-tabs-wrapper']/a[text()='Personal Details']")));
			
			List<Map<String, String>> valuesOfReadedExcelAddDetails = ExcelUtilities.ReadExcelData("CommonAccess.xlsx","AddEmployeeDetails");
			
			for(Map<String, String> values : valuesOfReadedExcelAddDetails)
			{
				String drivinglicenseNumber = values.get("DriverLicenseNumber");
				String nationality =          values.get("Nationality");
				String maritalStatus =        values.get("MaritalStatus");
				String dateofBirth =          values.get("DateofBirth");
				String gender      =          values.get("Gender");
				String bloodtype      =       values.get("BloodType");
				String testField      =       values.get("Test_Field");
				
				AddEmployee addEmployee = new AddEmployee(driver);
				addEmployee.DrivingLicense.sendKeys(drivinglicenseNumber);
				
				SelectDate select = new SelectDate();
				SelectDate.selectGivenDate("//label[contains(text(),'License Expiry Date')]/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]", dateofBirth);
			}
			
		    
						
		}
	}
}
