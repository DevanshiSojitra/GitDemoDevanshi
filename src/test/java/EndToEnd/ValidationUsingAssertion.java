package EndToEnd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

//extends Base means  Base class 
//Using extends keyword we can use/inherit all methods from Base class to HomePage class
public class ValidationUsingAssertion extends Base{
	
	//You have to add this to access log4j
	public static Logger log = LogManager.getLogger(Base.class.getName());
		
	@BeforeTest
	public void openBrowser() throws IOException {
		driver = initializerDriver(); //get driver from initializerDriver method
		//to Use .properties file, you need to use these 3 line of code
		//Properties prop = new Properties();
		//FileInputStream file = new  FileInputStream("C:\\Users\\User\\EndToEndProject\\src\\main\\java\\Resources\\data.properties");
		//prop.load(file);
		log.error("Driver is initialized");
		log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url")); //will use prop object from Base class, bcoz we already defined it there, so do not write that code again
		//driver.get("http://www.qaclickacademy.com/");	
	}
	
	@Test
	public void basePaseNevigation() throws IOException {
		
		//Passing driver, which has life, but to use this driver in LandingPage file you have to create constructor
		LandingPage lp = new LandingPage(driver); //Go to LandingPage class/file and; call Page Object pattern
		//lp.getTitle().getText();
		
		log.info("Site launched successfully");
		
		//Check FEATURED COURSES is presented, if yes then script should pass
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		
		//Check Contact present in the navigation bar
		Assert.assertEquals(lp.contactNav().getText(), "CONTACT");
		
		//Check if text is present
		Assert.assertEquals(lp.text().isDisplayed(),true);
		
		Assert.assertTrue(lp.text().isDisplayed()); // Condition should be true condition
		
		Assert.assertTrue(lp.text().isDisplayed(), "Yes, String/Text is present");
		
		//if text is not displayed then script should fail and print the message
		//Here text is presented so it will throw an error
		//Assert.assertFalse(lp.text().isDisplayed(), "Yes, String/Text is present"); //message
		
		System.out.println("Pass!!! All Elemnets are present");
		
		driver.close();
	}
	
	
	
	
}
