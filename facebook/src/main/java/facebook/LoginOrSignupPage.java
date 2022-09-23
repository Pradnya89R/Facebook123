package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignupPage {

	@FindBy (xpath = "//input[@id='email']")
	private WebElement UserName;
	
	@FindBy (xpath = "//input[@name='pass']")
	private WebElement Password;
	
	

	@FindBy (xpath = "//button[@name='login']")
	private WebElement LoginButton;
	

	@FindBy (xpath = "//a[@id='u_0_0_ZG']")
	private WebElement createNewacc;
	
	@FindBy (xpath = "//a[text() = 'Messenger']")
	private WebElement messengerLink;
	
	//public constructor to initialize web element
	public LoginOrSignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	// public methods
	
	public void sendUserName()
	{
		UserName.sendKeys("abc@gmail.com");
	}
	
	public void sendPassword()
	{
		Password.sendKeys("pradnya");
	}

	public void clickOnLoginButton()
	{
		LoginButton.click();
	}

	public void clickOnCreateneaccButton()
	{
		createNewacc.click();
	}
	
	public void openMesenger()
	{
		messengerLink.click();
	}

}

