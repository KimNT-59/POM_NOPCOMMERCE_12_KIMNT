package com.nopcommerce.framework;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.AbstractPageObject;
import pageFactory.HomePO;
import pageFactory.LoginPO;
import pageFactory.RegisterPO;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_04_Selenium_Page_Factory {
	AbstractPageObject abstractPage;
	WebDriver driver;
	Select select;
	String email;

	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;

	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resource\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver", +
		// ".\\resource\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Driver ID = " + driver.toString());

		email = "john_wick" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePO(driver);
	}

	@Test
	public void TC_01_Register() {
		System.out.println("Home Page - Click Register Link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPO(driver);

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
		assertTrue(registerPage.isSuccessMessageDisplayed());
		// assertEquals(registerPage.getSuccessMessageText(), "Your registration
		// completed");

		System.out.println("Register Page - Click to Logout link -> navigate to Home page");
		registerPage.clickToLogoutLink();
		homePage = new HomePO(driver);
	}

	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click Login Link");
		homePage.clickToLoginLink();
		loginPage = new LoginPO(driver);
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox(email);
		System.out.println("Login Page - Input to PW textbox");
		loginPage.inputToPasswordTextbox("123123");
		System.out.println("Login Page - Input to Login button>> Navigate to Home page");
		loginPage.clickToLoginbutton();
		homePage = new HomePO(driver);
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