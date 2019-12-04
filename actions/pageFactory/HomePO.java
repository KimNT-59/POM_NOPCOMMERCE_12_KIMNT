package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class HomePO extends AbstractPageFactory {

	public HomePO(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, HomePO.class);
	}

	@FindBy(how = How.CSS, using = "ico-register")
	private WebElement registerLink;

	@FindBy(how = How.CSS, using = "ico-login")
	private WebElement loginLink;

	@FindBy(how = How.CSS, using = "ico-account")
	private WebElement accountLink;

	@FindBy(how = How.CSS, using = "ico-logout")
	private WebElement logoutLink;

	public void clickToRegisterLink() {
		waitToElementVisible(registerLink);
		clickToElement(registerLink);

	}

	public void clickToLoginLink() {
		waitToElementVisible(loginLink);
		clickToElement(loginLink);
	}

	public boolean isMyAccountLinkisDisplayed() {
		waitToElementVisible(accountLink);
		return isElementDisplayed(accountLink);
	}

	public boolean isLogoutLinkisDisplayed() {
		waitToElementVisible(logoutLink);
		return isElementDisplayed(logoutLink);
	}
}