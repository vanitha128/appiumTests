package materialLogin;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignInPage;
import setup.SetupAndroidTest;

public class MaterialLoginSignInTest extends SetupAndroidTest {

	private static final String ANDROID_DEVICE_NAME = "Android Emulator";
	private static final String MATERIAL_LOGIN_APK = "/MaterialLoginExample.apk";
	private static final String APPIUM_AUTOMATION_NAME = "Appium";
	private static final String NEW_COMMAND_TIMEOUT = "60";

	@DataProvider(name = "testDataForSignInTest")
	public Object[][] getDataForSignInTest() {
		return new Object[][] { { "abcd@gmail.com", "abcdefghi" }, };

	}

	@BeforeSuite
	public void setupDriver() throws MalformedURLException {
		driver = setupDriver(ANDROID_DEVICE_NAME, MATERIAL_LOGIN_APK, APPIUM_AUTOMATION_NAME, NEW_COMMAND_TIMEOUT);
	}

	@Test(enabled = true, groups = { "signin", "critical" }, dataProvider = "testDataForSignInTest")

	public void signInTest(String email, String password) throws InterruptedException {

		SignInPage signInPage = new SignInPage(driver);

		signInPage.enterUserName(email);
		signInPage.enterPassword(password);
		signInPage.clickSubmitButton();

		// validation that home page is displayed after sign in.
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isInitialized());

	}

}
