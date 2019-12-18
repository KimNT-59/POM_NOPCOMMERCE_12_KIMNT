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

import PageObject.FooterMyAccountPage;
import PageObject.HeaderMyAccountPO;
import PageObject.HomePageObject;
import PageObject.SearchPO;
import PageObject.ShippingAndReturnPO;
import PageObject.SiteMapPO;
import pageUIs.AbstractPageUI;

public class AbstractPageObject {
	WebDriver driver;
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

		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);
		action = new Actions(driver);
	}

	public void openUrl(String urlValue) {
		driver.get(urlValue);

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void refreshInPage() {
		driver.navigate().refresh();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void waitAlertPresence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void clickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.getFirstSelectedOption().getText();
	}

	public String getValueInDropdown(String locator) {
		element = driver.findElement(By.xpath(locator));
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
		element = driver.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));
		elements = driver.findElements(By.xpath(allItemsLocator));
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
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (element.isSelected() == false) {
			element.click();

		}
	}

	public void unCheckToCheckbox(String locator) {
		elements = driver.findElements(By.xpath(locator));
		if (element.isSelected() == true) {
			element.click();

		}
	}

	public boolean isElementDisplayed(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return element.isDisplayed();

	}

	public boolean isElementSelected(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return element.isSelected();

	}

	public boolean isElementEnabled(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return element.isEnabled();

	}

	public void switchToChildWindowByID(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}

		}
	}

	public void switchToFrameOriFrame(String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
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

	// 28 hàm để mở ra 28 pages
	public HeaderMyAccountPO openHeaderMyAccountPage() {
		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHeaderMyAccountPage(driver);
	}

	public HomePageObject openHomePage() {
		waitToElementVisible(AbstractPageUI.HEADER_HOMEPAGE_LINK);
		clickToElement(AbstractPageUI.HEADER_HOMEPAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public SiteMapPO openSiteMapPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_SITEMAP_LINK);
		clickToElement(AbstractPageUI.FOOTER_SITEMAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	public SearchPO openSearchPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_SEARCH_LINK);
		clickToElement(AbstractPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public FooterMyAccountPage openFooterMyAccountPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	public ShippingAndReturnPO openShippingAndReturn() {
		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getShippingAndReturnPage(driver);
	}

}