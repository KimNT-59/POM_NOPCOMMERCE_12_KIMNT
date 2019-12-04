package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageObject {
    WebDriver driverGlobal;
	WebElement element;
	List<WebElement> elements;
	Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;
	Actions action;
	By by;
	long shortTimeout = 5;
	long longTimeout = 30;

	public AbstractPageObject(WebDriver driverLocal) {

		driverGlobal = driverLocal;
		jsExecutor = (JavascriptExecutor) driverGlobal;
		waitExplicit = new WebDriverWait(driverGlobal, 30);
		action = new Actions(driverGlobal);
	}

	public void openUrl(String urlValue) {
		driverGlobal.get(urlValue);

	}

	public String getPageTitle() {
		return driverGlobal.getTitle();
	}

	public String getPageCurrentUrl() {
		return driverGlobal.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driverGlobal.getPageSource();
	}

	public void backToPage() {
		driverGlobal.navigate().back();
	}

	public void refreshInPage() {
		driverGlobal.navigate().refresh();
	}

	public void forwardToPage() {
		driverGlobal.navigate().forward();
	}

	public void waitAlertPresence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		driverGlobal.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driverGlobal.switchTo().alert().dismiss();
	}

	public void sendKeyToAlert(String value) {
		driverGlobal.switchTo().alert().sendKeys(value);
	}

	public String getTextAlert() {
		return driverGlobal.switchTo().alert().getText();
	}

	public void clickToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(String locator, String value) {
		element = driverGlobal.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		select.getFirstSelectedOption().getText();
	}

	public String getValueInDropdown(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void sleepInSecond(long numberInSecond) {
		try {
			Thread.sleep(numberInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void selectItemInDropdown(String parentLocator, String allItemsLocator, String expectedItem) {
		element = driverGlobal.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));
		elements = driverGlobal.findElements(By.xpath(allItemsLocator));
		for (WebElement item : elements) {
			System.out.println(item.getText());
			if (item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("argument[0].scrollInToView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(2);
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		if (element.isSelected() == false) {
			element.click();

		}
	}

	public void unCheckToCheckbox(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		if (element.isSelected() == true) {
			element.click();

		}
	}

	public boolean isElementDisplayed(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		return element.isDisplayed();

	}

	public boolean isElementSelected(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		return element.isSelected();

	}

	public boolean isElementEnabled(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		return element.isEnabled();

	}

	public void switchToChildWindowByID(String parent) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driverGlobal.switchTo().window(runWindow);
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		driverGlobal.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driverGlobal.switchTo().window(runWindows);
				driverGlobal.close();
			}
		}
		driverGlobal.switchTo().window(parentWindow);
		if (driverGlobal.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		for (String runWindows : allWindows) {
			driverGlobal.switchTo().window(runWindows);
			String currentWin = driverGlobal.getTitle();
			if (currentWin.equals(title)) {
				break;
			}

		}
	}

	public void switchToFrameOriFrame(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		driverGlobal.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driverGlobal.switchTo().defaultContent();
	}

	public void hoverToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		boolean status;
		element = driver.findElement(By.xpath(locator));
		status = (boolean) jsExecutor.executeAsyncScript(
				"return argument[0].complete && typeof arguments[0].naturaWith !=\"undefined\" && argument[0].naturaWidth>0",
				element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitToElementVisible(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToElementPresence(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitToElementInvisible(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitToElementClickable(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}
}