package tests;

import framework.pageobject.PageObject;
import framework.pageobject.page.HomePage;
import framework.pageobject.page.LoginPage;
import framework.utils.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
	private final String LOGIN = PropertyLoader.getInstance().getUsername();
	private final String PASSWORD = PropertyLoader.getInstance().getPassword();
	private static final String UNABLE_TO_VERIFY_CREDENTIALS_ERROR_MESSAGE = "Unable to verify credentials";

	LoginPage loginPage;

	@BeforeMethod
	public void beforeMethod() {
		loginPage = new LoginPage();
	}

	@Features("Login Page")
	@Stories("Successfull login")
	@Test
	public void canLoginWithValidCredentials() {
		HomePage homePage = loginPage.loginAs(LOGIN, PASSWORD);

		String actualUsername = homePage.getTopMenuBlock().getUsername();

		assertEquals(actualUsername, LOGIN);
	}

	@Features("Login Page")
	@Stories("Log in with invalid credentials")
	@Test
	public void canNotLoginWithIncorrectLogin() {
		PageObject page = loginPage.tryLoginAs(LOGIN, "incorrect pasword");
		assertInstanceOf(page, LoginPage.class);

		loginPage = (LoginPage) page;
		String errorMessage = loginPage.getErrorMessage();

		Assert.assertEquals(errorMessage, UNABLE_TO_VERIFY_CREDENTIALS_ERROR_MESSAGE);
	}

	@Features("Login Page")
	@Stories("Log in with empty credentials")
	@Test(dataProvider = "credentials")
	public void shouldAlertAppearsIfLogInWithEmptyCredentials(String login, String password) {
		loginPage.login(login, password);

		Assert.assertTrue(loginPage.isAlertPresent(), "Alert is not present");
	}

	@DataProvider
	public Object[][] credentials() {
		return new Object[][]{ //
				{"", PASSWORD}, //
				{LOGIN, ""} //
		};
	}
}
