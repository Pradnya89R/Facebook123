package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import facebook.LoginOrSignupPage;
import facebook.Messenger;
import facebook.Roomspage;

public class TestNgClass {
	
	private WebDriver driver;
	private Roomspage roomspage;
	private LoginOrSignupPage loginOrSignupPage;
	
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Before class");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void openRoomsPage()
	{
		System.out.println("before method");
		driver.get("https://www.facebook.com/");
		
		LoginOrSignupPage loginOrSignupPage = new LoginOrSignupPage(driver);
		loginOrSignupPage.openMesenger();
		
		String messengerPageURL=driver.getCurrentUrl();
		
		if(messengerPageURL.equals("https://www.messenger.com/"))
		{
			System.out.println("messenger URL is verified");
		}
		else
		{
			System.out.println("messenger URL is not verified");
		}
		
		
		Messenger messenger = new Messenger(driver);
		messenger.openRooms();
		
		String messengerRoomPageURL= driver.getCurrentUrl();
	
		if(messengerRoomPageURL.equals("https://www.messenger.com/rooms"))
		{
			System.out.println("Messenger roompage URL is verified");
		}
		else
		{
			System.out.println("Messengerroompage URL is not verified");
		}
		
		
		roomspage= new Roomspage(driver);
	}
		
	
	@Test
	
	public void verifyGoBackToMessengerButton()
	{
		System.out.println("Test 1");

		roomspage.goBackToMessenger();
		
		String url= driver.getCurrentUrl();
		String title =driver.getTitle();
		if(url.equals("https://www.messenger.com/") && title.equals("Messenger"))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case failed");
		}
	}
@Test
	
	public void verifyContactToHelpCenterButton()
	{
	System.out.println("Test 2");

		roomspage.contactToHelpcenter();
		
		String url= driver.getCurrentUrl();
		String title =driver.getTitle();
		if(url.equals("https://www.messenger.com/") && title.equals("Messenger"))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case failed");
		}
	}

	
	@AfterMethod
	public void logoutfromApplication()
	{
		System.out.println("after method");
		System.out.println("Logout");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("after class");
		driver.close();
	}

}
