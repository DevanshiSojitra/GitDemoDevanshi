package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By emailAddress = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By logIn = By.xpath("//input[@value='Log In']");

	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement mailAddress() {
		return driver.findElement(emailAddress);
	}
			
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement logIn() {
		return driver.findElement(logIn);
	}
	
}
