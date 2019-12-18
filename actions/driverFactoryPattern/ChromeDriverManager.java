package driverFactoryPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
 @Override
    protected void createDriver() {
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("----start-maximized");
	// options.addArguments("headless");
	 options.addArguments("---incognito");
	 options.addArguments("---disable-intobars");
	 //options.addArguments("window-size-1920x1080");
	 driver = new ChromeDriver(options);
 }
}

