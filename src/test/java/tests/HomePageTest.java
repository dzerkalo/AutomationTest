package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.Set;
import java.util.TreeSet;

public class HomePageTest extends BaseTest {

	@Features("Home page")
	@Stories("Content of Home Page")
	@Test
	public void canVerifyContentOfHomePage() {
		//create Set of expected folders
		Set<String> expectedFolders = new TreeSet<>();
		expectedFolders.add("File Sharing");
		expectedFolders.add("test");

		Set<String> actualFolders = homePage.getAvailableFolders();

		Assert.assertEquals(actualFolders, expectedFolders);
	}
}
