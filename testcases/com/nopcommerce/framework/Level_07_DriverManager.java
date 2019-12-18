package com.nopcommerce.framework;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;

public class Level_07_DriverManager extends AbstractTest {
    private WebDriver driver;
	Select select;
	String email;
	private DriverManager driverManager;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name - " + browserName);
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		//driver = getBrowserDriver(browserName);

		System.out.println("Driver at Class test - " + driver.toString());

		//openMultiBrowser(browserName);

		// switch (browserName) {
		// case "firefox_ui":
		// System.setProperty("webdriver.gecko.driver", rootFolder +
		// ".\\resource\\geckodriver.exe");
		// System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,
		// "true");
		// System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder +
		// "\\firefoxLogs.txt");
		// driver = new FirefoxDriver();
		// break;
		// case "firefox_headless":
		// System.setProperty("webdriver.gecko.driver", rootFolder +
		// ".\\resource\\geckodriver.exe");
		// FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true);
		// driver = new FirefoxDriver(options);
		// break;
		// case "chrome_ui":
		// System.setProperty("webdriver.gecko.driver", rootFolder +
		// ".\\resource\\geckodriver.exe");
		// driver = new ChromeDriver();
		// break;
		// case "Chrome_headless":
		// System.setProperty("webdriver.gecko.driver", rootFolder +
		// ".\\resource\\geckodriver.exe");
		// ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		// driver = new FirefoxDriver(options);
		// break;
		// default:
		// System.out.println("Please input your browser Name!");
		// break;
		// }

		email = "john_wick" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register() {
		System.out.println("Open Url - Navigate to Home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		System.out.println("Home Page - Click Register Link");
		registerPage = homePage.clickToRegisterLink();

		System.out.println("Register Page - Click to Gender radio button");
		registerPage.clickToMaleRadioButton();

		System.out.println("Register Page - Input to Firtname textbox");
		registerPage.inputToFirtnameTextbox("Jonh");

		System.out.println("Register Page - Input to Lastname textbox");
		registerPage.inputToLastnameTextbox("Wick");

		System.out.println("Register Page - Input to Email textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("Register Page - Input to Password textbox");
		registerPage.inputToPasswordTextbox("123123");

		System.out.println("Register Page - Input to Confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox("123123");

		System.out.println("Register Page - Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Verify success mess displayed");
		assertTrue(registerPage.isSuccessMessageisDisplayed());
		// assertEquals(registerPage.getSuccessMessageText(), "Your registration
		// completed");

		System.out.println("Register Page - Click to Logout link -> navigate to Home page");
		registerPage.clickToLogoutLink();
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click Login Link");
		loginPage = homePage.clickToLoginLink();

		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox(email);

		System.out.println("Login Page - Input to PW textbox");
		loginPage.inputToPasswordTextbox("123123");

		System.out.println("Login Page - Input to Login button>> Navigate to Home page");
		loginPage = loginPage.clickToLoginbutton();

		System.out.println("Home Page - Verify My Account and logout link is displayed");
		assertTrue(homePage.isMyAccountLinkisDisplayed());
		assertTrue(homePage.isLogoutLinkisDisplayed());
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}