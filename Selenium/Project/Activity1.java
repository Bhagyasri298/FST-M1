package ProjectActivitites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	String title;
	@BeforeMethod
	public void beforeMethod() {
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		//Open browser
		driver.get("https://alchemy.hguy.co/jobs");
	}
	@Test
	public void getAlchemyTitle() {
		// Check the title of the page

		title = driver.getTitle();

		//Print the title of the page
		System.out.println("Page title is: " + title);

		//Assertion for page title
		Assert.assertEquals("Alchemy Jobs � Job Board Application", title);	
	}


	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}

}