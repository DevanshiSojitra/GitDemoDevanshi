package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	//Base class reusable file to initialize driver with Global Variables
		/* Because if there are 100s of test cases, and tomorrow client change the design of pages/application 
			and you would like still run all tests, it will be not good habit to go back to every tests
			and change the path of objects, you can simply come to Base file and change the object's path
			as needed. And that will work for all tests.
		This is smart to maintain your code.
		*/
	
	public WebDriver driver; // public keyword allows to use/access driver for all classes
	public Properties prop; // publicly defined so I can use it for other classes as well
	
	
	
	public WebDriver initializerDriver() throws IOException{
		// Use Properties to read data sets from Properties file: This is called Data Driven testing
		prop = new Properties();
		//Read file from data.properties file location
		FileInputStream file = new FileInputStream("C:\\Users\\User\\EndToEndProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(file); //load file to prop means properties
		
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();	
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Time out Implicitly (Means after executing every command, browser can wait max 5 second to read another code)
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//driver.get("url");
		driver.manage().window().maximize(); // Maximize window
		
		System.out.println("Hello");
		
		return driver;
		
	}
	
	
	
	
	
}
