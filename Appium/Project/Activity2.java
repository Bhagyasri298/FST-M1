package ProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4_Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.google.android.keep");
	    caps.setCapability("appActivity", ".activities.BrowseActivity");
	    caps.setCapability("noReset ", true);
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	    wait = new WebDriverWait(driver, 20);
		Thread.sleep(3000);
	    
	  }
	@Test
	public void addNotes() throws InterruptedException {
			  
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
		   driver.findElementByAccessibilityId("New text note").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
		   driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Title-Activity2 -Google Keep Notes");
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/edit_note_text")));
		   driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Hello..Reminder note to complete Appium project");
		   Thread.sleep(3000);
		   driver.findElementByAccessibilityId("Open navigation drawer").click();
		   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));
		   String Title=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		   String Description=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		   Assert.assertEquals("Title-Activity2 -Google Keep Notes",Title);
		   Assert.assertEquals("Hello..Reminder note to complete Appium project",Description);
      
	   }
	   
  @AfterClass
	public void close()
	{
		driver.quit();
	}
}
