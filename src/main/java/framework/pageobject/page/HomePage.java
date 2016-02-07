package framework.pageobject.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
	static final String ID_UPLOAD_BOX = "uploadBox";
	private static final String CSS_AJAX_PROGRESS = "img[src='/images/biz/ajax-progress2.gif']";
	private static final String CSS_LISTING_LOADED_ELEMENT = "#listing_loaded";
	private static final String CSS_FILE_LISTING_AREA = "#bizFileListing";
	private static final String CSS_FOLDER = ".dirEntry";

	public HomePage() {
		//wait until content is loaded
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_LISTING_LOADED_ELEMENT)));
	}

	@Step
	public Set<String> getAvailableFolders() {
		//get Set of actual folders
		List<WebElement> foldersList = driver.findElements(By.cssSelector(CSS_FILE_LISTING_AREA + " " + CSS_FOLDER));
		return foldersList.stream()
				.map(element -> element.getAttribute("bdg-name"))
				.collect(Collectors.toSet());
	}
}
