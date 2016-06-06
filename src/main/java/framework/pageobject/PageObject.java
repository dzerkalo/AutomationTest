package framework.pageobject;

import framework.utils.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class PageObject {
	protected final WebDriver driver;
	protected final WebDriverWait wait;


	public PageObject() {
		driver = DriverManager.getInstance().getDriver();
		this.wait = new WebDriverWait(driver, 15, 250);
		PageFactory.initElements(driver, this);
	}

	public Alert switchToAlert() {
		try {
			return driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			return null;

		}
	}

	@Step
	public Boolean isAlertPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
