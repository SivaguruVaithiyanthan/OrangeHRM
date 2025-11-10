package com.pages.locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	WebDriver driver = null;
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	public WebElement userName;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//h6[contains(@class,'oxd-topbar-header-breadcrumb')]")
	public WebElement DashBoard;
	
	@FindBy(xpath = "//span[text()='PIM']")
	public WebElement navMenuPIM;
	
	@FindBy(xpath = "//a[text() = 'Add Employee']")
	public WebElement addEmployee;
	
	@FindBy(xpath= "//input[@name='firstName']")
	public WebElement firstName;
	
	@FindBy(xpath= "//input[@name='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath= "//input[@name='lastName']")
	public WebElement empID;
	
	public void LoginValidation(String Username , String passWord)
	{
		userName.sendKeys(Username);
		password.sendKeys(passWord);
		loginButton.click();
	}
	
}
