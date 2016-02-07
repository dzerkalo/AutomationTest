package tests;

import framework.pageobject.page.HomePage;
import framework.pageobject.page.LoginPage;
import framework.utils.PropertyLoader;
import framework.utils.Screenshooter;
import framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
	protected HomePage homePage;

	@BeforeClass
	public void beforeClass() {
		WebDriver driver = WebDriverFactory.getInstance().createDriver(PropertyLoader.getInstance().getBrowserName());

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeBaseMethod(Method method) {
		LoginPage loginPage = new LoginPage();
		loginPage.open();

		if (method.getDeclaringClass().equals(LoginTest.class)) {
			return;
		}

		homePage = loginPage.loginAs(PropertyLoader.getInstance().getUsername(), PropertyLoader.getInstance().getPassword());
	}

	@AfterMethod
	public void afterBaseMethod(ITestResult result) {
		WebDriverFactory.getInstance().getDriver().manage().deleteAllCookies();

		if (!result.isSuccess()) {
			Screenshooter.getInstance().takeFullPageShotForFailedTests();
		}
	}

	@AfterClass
	public void afterSuite() {
		WebDriverFactory.getInstance().getDriver().quit();
	}

	protected void assertInstanceOf(Object obj, Class<?> clazz) {
		String msg = String.format("Expected instance of <%1$s> class, but was <%2$s>",
				clazz.getSimpleName(), obj == null ? null : obj.getClass().getSimpleName());

		if (!clazz.isInstance(obj)) {
			Assert.fail(msg);
		}
	}
}
