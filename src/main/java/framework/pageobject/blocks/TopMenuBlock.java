package framework.pageobject.blocks;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class TopMenuBlock extends PageObject {
	private static final String CSS_TITLE_ELEMENT = ".info[title]";
	private static final String CSS_FULLNAME_ELEMENT = ".name a";

	private final WebElement topMenuBlock;

	public TopMenuBlock(WebElement topMenu) {
		this.topMenuBlock = topMenu;
	}

	@Step
	public String getUsername() {
		return topMenuBlock.findElement(By.cssSelector(CSS_TITLE_ELEMENT)).getAttribute("data");
	}

	@Step
	public String getFullName() {
		return topMenuBlock.findElement(By.cssSelector(CSS_FULLNAME_ELEMENT)).getText();
	}
}
