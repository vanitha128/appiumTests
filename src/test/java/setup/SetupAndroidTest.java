package setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SetupAndroidTest {
	 public static AndroidDriver<MobileElement> driver;
	public static URL url;
	public static DesiredCapabilities capabilities;

	public AndroidDriver<MobileElement> setupDriver(String AndroidDeviceName, String apk, String automationName, String newCommandTimeout) throws MalformedURLException {
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		url = new URL(URL_STRING);
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AndroidDeviceName);
		final String dir = System.getProperty("user.dir");
		capabilities.setCapability(MobileCapabilityType.APP, dir + apk);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}

	@AfterSuite
	public void uninstallApp() throws InterruptedException {

	}

}
