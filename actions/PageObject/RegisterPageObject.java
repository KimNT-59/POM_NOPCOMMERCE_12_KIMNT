package PageObject;

import org.openqa.selenium.WebDriver;
import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPageObject {
	WebDriver driver;

	public RegisterPageObject(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	public void clickToMaleRadioButton() {
		waitToElementVisible(RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirtnameTextbox(String firstNameValue) {
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);

	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String pwValue) {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, pwValue);

	}

	public void inputToConfirmPasswordTextbox(String confirmPWValue) {
		waitToElementVisible(RegisterPageUI.CONFIRM_PW_TEXTBOX);
		sendKeyToElement(RegisterPageUI.CONFIRM_PW_TEXTBOX, confirmPWValue);

	}

	public void clickToRegisterButton() {
		waitToElementVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);

	}

	public boolean isSuccessMessageisDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_SUCCESSMESS);
		return isElementDisplayed(RegisterPageUI.REGISTER_SUCCESSMESS);
	}

//	public String getSuccessMessageText() {
	// waitToElementVisible(RegisterPageUI.REGISTER_TEXT);
	// return getTextElement(RegisterPageUI.REGISTER_TEXT);
	// }

	public HomePageObject clickToLogoutLink() {
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		clickToElement(RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}