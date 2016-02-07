package framework.pageobject.page;

import framework.pageobject.PageObject;
import framework.utils.ControlsHelper;
import framework.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends PageObject {
	private static final String CSS_LOGIN_FIELD = "#txtLogin";
	private static final String CSS_PASSWORD_FIELD = "#txtPassword";
	private static final String CSS_LOGIN_BUTTON = "#loginBtnSecText p";
	private static final String CSS_ALERT_MESSAGE = "#alertBox center";

	public void open() {
		driver.get(PropertyLoader.getInstance().getAppUrl());
	}

	/**
	 * Use this method if you do not know exactly whether if you use for logging in valid credentials or not
	 *
	 * @param login
	 * @param password
	 * @return new HomePage if login was successfull, otherwise return this (LoginPage)
	 */
	@Step
	public PageObject tryLoginAs(String login, String password) {
		String currentUrl = driver.getCurrentUrl();

		login(login, password);

		try {
			switchToAlert().accept();
		} catch (NullPointerException e) {
		}

		String newUrl = driver.getCurrentUrl();

		// If log in was successfull we are on HomePage, else we are still on LoginPage
		if (!currentUrl.equals(newUrl)) {
			if (!driver.findElements(By.id(HomePage.ID_UPLOAD_BOX)).isEmpty()) {
				return new HomePage();
			}
		}

		return new LoginPage();
	}

	/**
	 * Use this method if you use for logging in only valid credentials
	 *
	 * @param login
	 * @param password
	 * @return new HomePage
	 */
	@Step
	public HomePage loginAs(String login, String password) {
		PageObject page = tryLoginAs(login, password);

		if (!(page instanceof HomePage)) {
			throw new IllegalArgumentException(
					String.format("Couldn't login with valid credentials (%1$s//%2$s)", login, password));
		} else {
			return (HomePage) page;
		}
	}

	@Step
	public void login(String login, String password) {
		ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)), login);
		ControlsHelper.fillTextBox(driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)), password);
		driver.findElement(By.cssSelector(CSS_LOGIN_BUTTON)).click();
	}

	public String getErrorMessage() {
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ALERT_MESSAGE)));

		return errorMessage.getText();
	}
}
