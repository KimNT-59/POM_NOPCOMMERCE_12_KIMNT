package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPO extends AbstractPageFactory {
    public RegisterPO(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, RegisterPO.class);
	}

	@FindBy(how = How.ID, using = "")
	private WebElement genderMaleRadioButton1;

	@FindBy(how = How.ID, using = "FirstName")
	private WebElement firstNameTextbox;

	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;

	@FindBy(how = How.ID, using = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;

	@FindBy(how = How.CSS, using = "Register-button")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = ".result")
	private WebElement registerSuccessText;

	@FindBy(how = How.CSS, using = ".ico-logout")
	private WebElement logoutLink;

	public void clickToMaleRadioButton() {
		waitToElementVisible(genderMaleRadioButton1);
		clickToElement(genderMaleRadioButton1);
	}

	public void inputToFirtnameTextbox(String firstNameValue) {
		waitToElementVisible(firstNameTextbox);
		sendKeyToElement(firstNameTextbox, firstNameValue);

	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(lastNameTextbox);
		sendKeyToElement(lastNameTextbox, lastNameValue);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, email);

	}

	public void inputToPasswordTextbox(String pwValue) {
		waitToElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, pwValue);

	}

	public void inputToConfirmPasswordTextbox(String confirmPWValue) {
		waitToElementVisible(confirmPasswordTextbox);
		sendKeyToElement(confirmPasswordTextbox, confirmPWValue);

	}

	public void clickToRegisterButton() {
		waitToElementVisible(registerButton);
		clickToElement(registerButton);

	}

	public String getSuccessMessageText() {
		waitToElementVisible(registerSuccessText);
		return getTextElement(registerSuccessText);

	}

//	public String getSuccessMessageText() {
	// waitToElementVisible(RegisterPageUI.REGISTER_TEXT);
	// return getTextElement(RegisterPageUI.REGISTER_TEXT);
	// }

	public void clickToLogoutLink() {
		waitToElementVisible(logoutLink);
		clickToElement(logoutLink);
	}

	public boolean isSuccessMessageDisplayed() {
		waitToElementVisible(registerSuccessText);
		return isElementDisplayed(registerSuccessText);
	}

}