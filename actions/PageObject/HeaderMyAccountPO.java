package PageObject;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class HeaderMyAccountPO extends AbstractPageObject{
WebDriver driverGlobal;
	public HeaderMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal= driverLocal;
	}

}
