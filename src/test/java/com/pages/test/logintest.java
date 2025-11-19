package com.pages.test;

import com.pages.base.base;
import com.pages.locators.loginPage;
import com.pages.utilities.ExcelUtilities;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class logintest extends base {

	loginPage loginObjects;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@BeforeClass
	public void setUp() {
		initializeWebBrowser();
		loginObjects = new loginPage(driver);
		String titleName = driver.getTitle();
		String expectedTitleText = "OrangeHRM";
		if (titleName.trim() == expectedTitleText.trim()) {
			System.out.println("Page Loaded SuccessFully.");
		}
	}

	@BeforeTest()
	private static List<Map<String, String>> dataBaseOutPut() {
		List<Map<String, String>> valuesOfDB = ExcelUtilities.ReadExcelData("Loginpasswords.xlsx","LoginPageCredentials");
		return valuesOfDB;
	}

	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("Validate the loginPage..");
	}

	@Test(priority = 1)
	public void ValidLogin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int invalidCount = 0;
		for (Map<String, String> Values : dataBaseOutPut()) {
			String userName = Values.get("userName");
			String passWord = Values.get("passWord");
			loginObjects.LoginValidation(userName, passWord);

			if (!checkValidCredentials(driver)) {
				DasboardValidation();
			} else {
				invalidCount++;
				System.out.println("invalid Credentials.." + invalidCount);
			}
		}
	}

	public void DasboardValidation() throws InterruptedException {
		try {
			loginObjects = new loginPage(driver);
			String dasboardText = loginObjects.DashBoard.getText();
			String expectedDashBoardText = "Dashboard";
			Assert.assertEquals(dasboardText, expectedDashBoardText);

			WebElement navMenu = driver.findElement(By.xpath("//ul[contains(@class,'oxd-main-menu')]"));
			List<WebElement> navigationSubMenus = navMenu.findElements(By.tagName("li"));
			for (WebElement element : navigationSubMenus) {
				System.out.println("Navigation Menus : " + element.getText().trim());
			}

			for (int i = 0; i < navigationSubMenus.size(); i++) {
				List<WebElement> navigation = driver
						.findElements(By.xpath("//ul[contains(@class,'oxd-main-menu')]//li"));
				WebElement nowtMenu = navigation.get(i);
				String menuName = nowtMenu.getText().trim();
				System.out.println("Current Nav Menu is  : " + menuName);
				WebElement currentMenu = driver.findElement(By.xpath("//span[text()='" + menuName + "']"));
				currentMenu.click();
				Thread.sleep(2000);
				captureScreenshot.captureScreenShot(driver, menuName);
			}
		} catch (Exception Ex) {
			System.out.println("Error Occured in this scenrarion : " + Ex.getMessage());
		}

	}

	
	public void AddEmployee() {
		loginObjects = new loginPage(driver);
		List<Map<String, String>> valuesOfReadedExcel = ExcelUtilities.ReadExcelData("CommonAccess.xlsx","AddEmployeeDetails");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(loginObjects.navMenuPIM)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginObjects.addEmployee)).click();

		for (Map<String, String> Values : valuesOfReadedExcel) {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) loginObjects.firstName));

			String firstName = Values.get("FirstName");
			String lastName = Values.get("LastName");
			String empID = Values.get("EmpID");

			loginObjects.firstName.sendKeys(firstName);
			loginObjects.lastName.sendKeys(lastName);
			loginObjects.empID.sendKeys(empID);

			wait.until(ExpectedConditions.elementToBeClickable(loginObjects.saveButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-tabs-wrapper']/a[text()='Personal Details']")));
			
			
		}
	}

	public boolean checkValidCredentials(WebDriver driver) {
		boolean invalidCredToast = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement toast = wait
					.until(ExpectedConditions.visibilityOfElementLocated((loginObjects.invalidToastMessage)));
			invalidCredToast = toast.isDisplayed();
		} catch (Exception e) {
			invalidCredToast = false;
		}
		return invalidCredToast;
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Login Page Validated SuccessFully...");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		loginObjects = new loginPage(driver);
		loginObjects.LogoutMain.click();
		Thread.sleep(1000);
		loginObjects.logOut.click();
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
		System.out.println("Browser Closed SuccessFully...");
	}

}
