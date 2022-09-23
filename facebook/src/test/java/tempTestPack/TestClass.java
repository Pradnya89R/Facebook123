package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facebook.LoginOrSignupPage;
import facebook.Messenger;
import facebook.Roomspage;

public class TestClass {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		LoginOrSignupPage loginOrSignupPage = new LoginOrSignupPage(driver);
		loginOrSignupPage.openMesenger();
		
		String messengerPageURL=driver.getCurrentUrl();
		System.out.println(messengerPageURL);
		if(messengerPageURL.equals("https://www.facebook.com/"))
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
		System.out.println(messengerRoomPageURL);
		if(messengerRoomPageURL.equals("https://www.messenger.com/rooms"))
		{
			System.out.println("Messengerroompage URL is verified");
		}
		else
		{
			System.out.println("Messengerroompage URL is not verified");
		}
		
		
		Roomspage roomspage= new Roomspage(driver);
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
}
