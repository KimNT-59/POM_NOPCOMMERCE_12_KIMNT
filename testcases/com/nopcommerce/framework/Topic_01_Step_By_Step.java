package com.nopcommerce.framework;

import static org.testng.AssertJUnit.assertTrue;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_01_Step_By_Step {

    WebDriver driver;
	Select select;
	String email = "john_wick" + randomNumber() + "@hotmail.com";

	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resource\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver", +
		// ".\\resource\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		// click to register page
		driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();

		// verify register page displayed
		assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());

		// Click to Gender radio button
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();

		// Input to first name textbox
		driver.findElement(By.xpath("//input[@id='Firstname']")).sendKeys("Jonh");
		// Input to last name textbox
		driver.findElement(By.xpath("//input[@id='Lastname']")).sendKeys("Wick");

		// select date of birthdropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("10");

		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("10");

		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("10");

		// input email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		// input company textbox
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Ninja Asssassin");
		// input PW textbox
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
		// input conformPW textbox
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");

		// click Register button
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		// click Register success
		assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']"))
				.isDisplayed());
		// click Logout page
		driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log out']")).click();
		// verif navigate to Home page success
		assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_Login() {
		// Click to Login button
		driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();

		// verify login page displayed
		assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());
		// input email textbox
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		// input conformPW textbox
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
		// click LOginbutton
		driver.findElement(By.cssSelector(".login-button")).click();

		// Verify Login link displayed
		assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());
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