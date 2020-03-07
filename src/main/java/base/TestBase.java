package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import util.extent_reporting;

public class TestBase 
{

public static String browser= "chrome";
public static WebDriver driver;
public static Properties prop;
public static String Child_Reporting;

public TestBase() {
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-proj\\src\\main\\java\\base\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

}


public void init() {
	String browserName = prop.getProperty("browser");
	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		
	} if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\Eclipse\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	} if (browserName.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\Eclipse\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
	} 
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
}

// After suit temp addition to check suit level implementation
@BeforeSuite
public void testStart() {
	extent_reporting.initializeReport();
}

@AfterSuite
public void teardown()
{
	extent_reporting.endReport();
}
 
}
