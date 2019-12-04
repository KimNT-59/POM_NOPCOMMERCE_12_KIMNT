package PageObject;

import org.openqa.selenium.WebDriver;
import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPageObject {
	WebDriver driver;

	public LoginPageObject(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(LoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String pw) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, pw);

	}

	public LoginPageObject clickToLoginbutton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}
}