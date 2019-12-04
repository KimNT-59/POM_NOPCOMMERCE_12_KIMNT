package commons;

import org.openqa.selenium.WebDriver;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driverLocal) {
		return new HomePageObject(driverLocal);
	}

	public static LoginPageObject getLoginPage(WebDriver driverLocal) {
		return new LoginPageObject(driverLocal);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driverLocal) {
		return new RegisterPageObject(driverLocal);
	}
}