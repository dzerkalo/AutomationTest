package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory to instantiate a WebDriver object. It returns an instance of the driver
 */
class DriverFactory {
	/* Browsers constants */
	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	private static final String CHROME_DRIVER_PATH = "src/main/resources/chrome/chromedriver.exe";

	private final static DriverFactory INSTANCE = new DriverFactory();

	private DriverFactory() {
	}

	static DriverFactory getInstance() {
		return INSTANCE;
	}

	/**
	 * Factory method to create a new WebDriver instance given to the browser. It should be created once per test suite
	 *
	 * @param browser: String representing the browser name (e.g. "chrome" or "firefox")
	 * @return WebDriver instance
	 */
	WebDriver createDriver(String browser) {
		if (CHROME.equalsIgnoreCase(browser)) {
			setChromeDriver();
			return new ChromeDriver();
		} else if (FIREFOX.equalsIgnoreCase(browser)) {
			return new FirefoxDriver();
		} else {
			throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", browser));
		}
	}

	/**
	 * Helper method to set ChromeDriver location into the right system property
	 */
	private void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
	}
}
