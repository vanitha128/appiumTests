package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageObject{

	public HomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id="com.sourcey.materialloginexample:id/action_bar")
	private MobileElement actionBar;
	
	
	public boolean isInitialized() {
		return actionBar.isDisplayed();
	}

}
