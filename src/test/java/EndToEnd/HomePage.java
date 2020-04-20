package EndToEnd;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;


//extends Base means  Base class 
//Using extends keyword we can use/inherit all methods from Base class to HomePage class
public class HomePage extends Base{
	
	//You have to add this to access log4j
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void openBrowser() throws IOException {
		driver = initializerDriver(); //get driver from initializerDriver method
		driver.get("http://www.qaclickacademy.com/");	
	}
	
	@Test (dataProvider = "dataSet") // Use this in () to use dataSet dataProvider method
	public void basePaseNevigation(String Username, String Password) throws IOException {
		
		driver.get("http://www.qaclickacademy.com/");
		//Passing driver, which has life, but to use this driver in LandingPage file you have to create constructor
		LandingPage lp = new LandingPage(driver); //Go to LandingPage class/file and; call Page Object pattern
		lp.SignIn().click(); //access/invoke SignIn() method
		
		log.info("Site launched successfully");
		
		LoginPage logPage = new LoginPage(driver);
		logPage.mailAddress().sendKeys(Username);
		logPage.password().sendKeys(Password);
		logPage.logIn().click();
	
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
	// Use dataprovider to store data set in the array, 
	//sendKeys("") data inside it should not hard coded in above method; thats why use DataProvider for that
	
	@DataProvider  
	public Object[][] dataSet() {
		
		//3 for 3 datasets, 2 for 2 values=what and where
		//3 rows and 2 cols // 2D array with 3 by 2
		Object[][] data = new Object[3][2];
		
		//Index starts with 0
		data[0][0] = "dev.com";
		data[0][1] = "1234";
		
		data[1][0] = "gmail.com";
		data[1][1] = "789saas";
		
		data[2][0] = "devusojitra@gmail.com";
		data[2][1] = "Ganeshji1@";
		
		return data;
		
	}
	
	
	
	
}
