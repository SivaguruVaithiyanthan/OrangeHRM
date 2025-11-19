package com.pages.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee 
{
	WebDriver driver = null;
	
	public AddEmployee(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[contains(text(),'Driver')]/parent::div/following-sibling::div//input[contains(@class,'oxd-input')]")
	public WebElement DrivingLicense;
	
	@FindBy(xpath = "//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
	public WebElement Nationlaity;
	
	@FindBy(xpath= "//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
	public WebElement MaritalStatus;
	
	@FindBy(xpath= "//label[text()='Date of Birth']/parent::div/following-sibling::div//input[contains(@placeholder,'dd-mm-yyyy')]")
	public WebElement DateofBirth;
	
	@FindBy(xpath= "//label[text()='Gender']/parent::div/following-sibling::div//input[contains(@value,'1')]")
	public WebElement Gender;
	
	@FindBy(xpath= "///label[text()='Blood Type']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
	public WebElement BloodGroup;
	
	@FindBy(xpath= "//label[text()='Test_Field']/parent::div/following-sibling::div/input[contains(@class,'oxd-input oxd-input--active')]")
	public WebElement Test_Field;
}
