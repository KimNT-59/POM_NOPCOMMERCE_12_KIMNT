package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class LoginPO extends AbstractPageFactory {
    public LoginPO(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, LoginPO.class);
	}

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox1;

	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;

	@FindBy(how = How.CSS, using = ".login-button")
	private WebElement loginButton;

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox1);
		sendKeyToElement(emailTextbox1, email);

	}

	public void inputToPasswordTextbox(String pw) {
		waitToElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, pw);

	}

	public void clickToLoginbutton() {
		waitToElementVisible(loginButton);
		clickToElement(loginButton);
	}

}