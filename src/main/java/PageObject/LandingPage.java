package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//1. Define object using its path 
	//PageObject method to define all object from Home page of website
	By signIn = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//div[@class='text-center']/h2");
	By contactNav = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[8]/a");
	By text = By.xpath("//h3[contains(text(), 'An Academy to learn')]");
	
	//2. Create constructor to make driver live
	//Create a constructor to use driver from test cases
	public LandingPage(WebDriver driver) {//here driver is coming from test and it has life from test
		this.driver = driver; //assign LandingPage class's driver to this constructor's driver
	}

	//3.Create method for object
	public WebElement SignIn() {
		return driver.findElement(signIn);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement contactNav() {
		return driver.findElement(contactNav);
	}
	public WebElement text() {
		return driver.findElement(text);
	}
	
}
