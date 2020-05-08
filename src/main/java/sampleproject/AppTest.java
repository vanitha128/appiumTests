package sampleproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class AppTest {
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;
  @BeforeSuite
  public void setupAppium() throws MalformedURLException {
    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    url = new URL(URL_STRING);
    capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    final String dir = System.getProperty("user.dir");
    capabilities.setCapability(MobileCapabilityType.APP, dir + "/MaterialLoginExample.apk");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }
  @AfterSuite
  public void uninstallApp() throws InterruptedException {

  }

  @Test (enabled=true) 
  public void myFirstTest() throws InterruptedException {
    MobileElement email = (MobileElement) driver.findElementById("com.sourcey.materialloginexample:id/input_email");
    email.clear();
    email.sendKeys("abc@gmail.com");
    MobileElement passwd = (MobileElement) driver.findElementById("com.sourcey.materialloginexample:id/input_password");
    passwd.sendKeys("abcdefghi");
    MobileElement submitButton = (MobileElement) driver.findElementById("com.sourcey.materialloginexample:id/btn_login");
    submitButton.click();
  }
}