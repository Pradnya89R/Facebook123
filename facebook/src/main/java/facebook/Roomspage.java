package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roomspage {
	
		
		@FindBy (xpath = "//a[text()= ' Return to messenger.com ']")
		private WebElement returnTomessenger;
		
		@FindBy (xpath = "//a[text() = ' Visit our help center ']")
		private WebElement helpCenter;
		
		
		public Roomspage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
		
		public void goBackToMessenger()
		{

			returnTomessenger.click();
		}

		public void contactToHelpcenter()
		{
			helpCenter.click();
		}
	}

