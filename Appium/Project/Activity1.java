package ProjectActivities;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class Activity1 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.google.android.apps.tasks");
	    caps.setCapability("appActivity", ".ui.TaskListsActivity");
	    caps.setCapability("noReset ", true);
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
	    wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get started']")));;
		driver.findElementByXPath("//android.widget.Button[@text='Get started']").click();
		Thread.sleep(3000);
	    
	  }
	@Test
	public void addTasklist() throws InterruptedException {
		String[] tasks_List= {"Complete Activity with Google Tasks"," Complete Activity with Google Keep","Complete the second Activity Google Keep"};
	   
	   for (String task:tasks_List)
	   {
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		   driver.findElementByAccessibilityId("Create new task").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		   driver.findElementById("add_task_title").sendKeys(task);
		   Thread.sleep(3000);	
		   driver.findElementById("add_task_done").click();
		   
	   }
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
	   List<MobileElement> addedtasks=driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	   int totalnotask=addedtasks.size();
	   Assert.assertEquals(3, totalnotask);
	   Assert.assertEquals(addedtasks.get(2).getText(), "Complete Activity with Google Tasks");
	   }
		  
  @AfterClass
	public void close()
	{
		driver.quit();
	}
}