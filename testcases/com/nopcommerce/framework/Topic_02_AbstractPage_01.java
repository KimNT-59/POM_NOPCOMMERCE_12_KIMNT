package com.nopcommerce.framework;

import static org.testng.AssertJUnit.assertTrue;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_02_AbstractPage_01  {
	AbstractPageObject abstractPage;
	WebDriver driver;
	Select select;
	String email;

	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resource\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver", +
		// ".\\resource\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Driver ID = " + driver.toString());
		abstractPage = new AbstractPageObject(driver);
		email = "john_wick" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		// click to register page
		// driver.findElement(By.xpath("//a[@class='ico-register' and
		// text()='Register']")).click();
		abstractPage.clickToElement("//a[@class='ico-register' and text()='Register']");
		// verify register page displayed
		// assertTrue(driver.findElement(By.xpath("//div[@class='page
		// registration-page']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//div[@class='page registration-page']"));
		// Click to Gender radio button
		// driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		abstractPage.clickToElement("//input[@id='gender-female']");
		// Input to first name textbox
		// driver.findElement(By.xpath("//input[@id='Firstname']")).sendKeys("Jonh");
		abstractPage.sendKeyToElement("//input[@id='FirstName']", "Jonh");
		// Input to last name textbox
		// driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		abstractPage.sendKeyToElement("//input[@id='LastName']", "Wick");
		// select date of birthdropdown
		// select = new
		// Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		// select.selectByVisibleText("10");

		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']","", "10");

		// select = new
		// Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		// select.selectByVisibleText("october");
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']","", "october");
//		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		// select.selectByVisibleText("1999");
		abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']","", "1999");
		// input email textbox
		// driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		// input company textbox
		// driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Ninja
		// Asssassin");
		abstractPage.sendKeyToElement("//input[@id='Company']", "Ninja Asssassin");
		// input PW textbox
		// driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		abstractPage.sendKeyToElement("//input[@id='Password']", "123123");
		// input conformPW textbox
		// driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", "123123");
		// click Register button
		// driver.findElement(By.xpath("//input[@id='register-button']")).click();
		abstractPage.clickToElement("//input[@id='register-button']");
		// click Register success
		// assertTrue(driver.findElement(By.xpath("//div[@class='result' and
		// text()='Your registration completed']"))
		// .isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//div[@class='result' and text()='Your registration completed']"));
		// click Logout page
		// driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log
		// out']")).click();
		abstractPage.clickToElement("//a[@class='ico-logout' and text()='Log out']");
		// verif navigate to Home page success
		// assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
		assertEquals(abstractPage.getPageCurrentUrl(), "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_Login() {
		// Click to Login button
		// driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log
		// in']")).click();
		abstractPage.clickToElement("//a[@class='ico-login' and text()='Log in']");
		// verify login page displayed
		// assertTrue(driver.findElement(By.xpath("//div[@class='page
		// login-page']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//div[@class='page login-page']"));
		// input email textbox
		// driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		abstractPage.sendKeyToElement("//input[@id='Email']", email);
		// input conformPW textbox

		// driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
		abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", "123123");
		// click LOginbutton
		driver.findElement(By.cssSelector(".login-button")).click();
		abstractPage.clickToElement("//input[@class='button-1 login-button']");
		// Verify Login link displayed
		// assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and
		// text()='My account']")).isDisplayed());
		assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account' and text()='My account']"));
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