package PageObject;

import org.openqa.selenium.WebDriver;
import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPageObject {
    WebDriver driverGlobal;

	public HomePageObject(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;

	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driverGlobal);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driverGlobal);
	}

	public boolean isMyAccountLinkisDisplayed() {
		waitToElementVisible(HomePageUI.ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.ACCOUNT_LINK);
	}

	public boolean isLogoutLinkisDisplayed() {
		waitToElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
	}

}