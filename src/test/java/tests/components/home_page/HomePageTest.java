package tests.components.home_page;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import tests.BaseTest;

import java.util.Set;
import java.util.TreeSet;

public class HomePageTest extends BaseTest {
	private static final String COMMENT_ADDED_MESSAGE = "Added comment";
	private static final String FILE_NAME = "links.txt";

	@Features("Home page")
	@Stories("Content of Home Page")
	@Test
	public void canVerifyContentOfHomePage() {
		//create Set of expected folders
		Set<String> expectedFolders = new TreeSet<>();
		expectedFolders.add("File Sharing");
		expectedFolders.add("Fun)");
		expectedFolders.add("test");

		Set<String> actualFolders = homePage.getAvailableFolders();

		Assert.assertEquals(actualFolders, expectedFolders);
	}

	//@Test
	public void canAddCommentToFile(){
		homePage.addCommentForFile(FILE_NAME, "Comment text");
		String actualMessage = homePage.getCommentMessageForFile(FILE_NAME);

		Assert.assertEquals(actualMessage, COMMENT_ADDED_MESSAGE);
	}
}
