package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {
    WebDriver driverGlobal;
	WebElement element;
	WebDriverWait waitExplicit;
	long shortTimeout = 5;
	long longTimeout = 30;

	public AbstractPageFactory(WebDriver driverLocal) {
		driverGlobal = driverLocal;
		waitExplicit = new WebDriverWait(driverLocal, longTimeout);
	}

	public void waitToElementVisible(WebElement element) {
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickToElement(WebElement element) {
		element.click();
	}

	public void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public String getTextElement(WebElement element) {
		return element.getText();
	}
}