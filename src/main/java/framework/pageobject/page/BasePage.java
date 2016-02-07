package framework.pageobject.page;

import framework.pageobject.PageObject;
import framework.pageobject.blocks.LeftMenuNavigationBlock;
import framework.pageobject.blocks.TopMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage extends PageObject {
	private static final String CSS_TOP_BLOCK = "#header-outside";
	private static final String CSS_MENU_NAVIGATION_BLOCK = "#menuBox";

	public TopMenuBlock getTopMenuBlock() {
		WebElement topMenu = driver.findElement(By.cssSelector(CSS_TOP_BLOCK));

		return new TopMenuBlock(topMenu);
	}

	public LeftMenuNavigationBlock getMenuNavigation() {
		WebElement topMenu = driver.findElement(By.cssSelector(CSS_MENU_NAVIGATION_BLOCK));

		return new LeftMenuNavigationBlock(topMenu);
	}
}
