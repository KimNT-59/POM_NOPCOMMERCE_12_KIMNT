package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadlessDriverManager extends DriverManager {
	/**
	 *
	 */
	@Override
	protected void createDriver() {

//		String rootFolder = System.getProperty("user.dir");
//		FirefoxProfile profile = new FirefoxProfile();
//		DesiredCapabilities capablity = DesiredCapabilities.firefox();
//		profile.setAcceptUntrustedCertificates(false);
//		profile.setAssumeUntrustedCertificateIssuer(true);
//		profile.setPreference("dom.webnotifications.enabled", false);
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		profile.setPreference("browser.download.manager.showWhenStarting", false);
//		profile.setPreference("browser.download.dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.downloadDir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.defaultFolder", rootFolder + "\\downloadFiles");
//		capablity = DesiredCapabilities.firefox();
//		capablity.setCapability(FirefoxDriver.PROFILE, profile);
//		driver = new FirefoxDriver(capablity);

		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + ".\\resource\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		driver = new FirefoxDriver(options);

	}
}