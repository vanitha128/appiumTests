package pageObjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class SignInPage extends PageObject{
	
	@AndroidFindBy(id="com.sourcey.materialloginexample:id/input_email")
	private MobileElement email;
	@AndroidFindBy(id="com.sourcey.materialloginexample:id/input_password")
	private MobileElement password;
	@AndroidFindBy(id="com.sourcey.materialloginexample:id/btn_login")
	private MobileElement submitButton;
	
	
	public SignInPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUserName(String emailVal) {
		this.email.clear();
	    this.email.sendKeys(emailVal);
	}
	
	public void enterPassword(String passwordVal) {
		this.password.sendKeys(passwordVal);

	}
	
	public void clickSubmitButton() {
		this.submitButton.click();
	}
	
	public boolean isInitialized() {
		return email.isDisplayed();
	}

}
