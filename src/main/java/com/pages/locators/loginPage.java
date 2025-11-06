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
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h6[contains(@class,'oxd-topbar-header-breadcrumb')]")
	private WebElement DashBoard;
	
	
	public void LoginValidation(String Username , String passWord)
	{
		userName.sendKeys(Username);
		password.sendKeys(passWord);
		loginButton.click();
	}
	
}
