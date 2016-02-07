package framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Screenshooter {
	private final static Screenshooter INSTANCE = new Screenshooter();

	private Screenshooter() {
	}

	public static Screenshooter getInstance(){
		return INSTANCE;
	}

	@Attachment(value = "ScreenshotAttachment", type = "image/png")
	public byte[] takeFullPageShotForFailedTests() {
		return ((TakesScreenshot) WebDriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
