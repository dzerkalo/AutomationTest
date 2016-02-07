package tests;

import framework.dataobjects.ProfileData;
import framework.pageobject.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static framework.utils.enums.TimeZone.AFRICA_ABIDJAN;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class EditProfileTest extends BaseTest {

	@Features("Profile page")
	@Stories("Profile editing")
	@Test(dataProvider = "profile")
	public void canEditProfileWithValidValues(ProfileData profile) {
		ProfilePage profilePage = homePage.getMenuNavigation().selectProfilePage();

		profilePage.editProfile(profile);

		profilePage = homePage.getMenuNavigation().selectProfilePage();
		ProfileData savedProfile = profilePage.getProfileData();

		Assert.assertEquals(savedProfile, profile, String.format("Profile data is not saved. Expected %1$s profile, + " +
				"but found %2$s", profile, savedProfile));

		String titleFullName = homePage.getTopMenuBlock().getFullName();
		String expectedFullName = profile.getFirstName() + " " + profile.getLastName();
		Assert.assertTrue(titleFullName.equalsIgnoreCase(expectedFullName),
				String.format("Expected %1$s Full Name in Title, but found %2$s", expectedFullName, titleFullName));
	}

	@DataProvider
	public Object[][] profile() {
		return new Object[][]{ //
				{new ProfileData.Builder() //
						.setFirstName(randomAlphabetic(2)) //
						.setLastName(randomAlphabetic(2)) //
						.setCompanyName(randomAlphabetic(2)) //
						.setWebsite("http://www.l.c") //
						.setTitle(randomAlphabetic(1)) //
						.setPhone(randomNumeric(7)) //
						.setTimeZone(AFRICA_ABIDJAN) //
						.setItemsPerPage(20) //
						.setMaxFileAge(0) //
						.build()}
		};
	}
}
