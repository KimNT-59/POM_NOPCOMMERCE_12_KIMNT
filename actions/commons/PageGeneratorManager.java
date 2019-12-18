package commons;

import org.openqa.selenium.WebDriver;

import PageObject.FooterMyAccountPage;
import PageObject.HeaderMyAccountPO;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;
import PageObject.SearchPO;
import PageObject.ShippingAndReturnPO;
import PageObject.SiteMapPO;

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

	public static HeaderMyAccountPO getHeaderMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SiteMapPO getSiteMapPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SearchPO getSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static FooterMyAccountPage getFooterMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ShippingAndReturnPO getShippingAndReturnPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
}
