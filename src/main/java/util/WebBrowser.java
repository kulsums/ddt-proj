package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import base.TestBase;

public class WebBrowser extends TestBase 
{
	
	public  ExtentTest test;
	public ExtentReports report;
	
	public void generatereport() {
		String str = getCurrentTime();
		report = new ExtentReports("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-proj\\test-output\\ExtentReportResults_"+ str + ".html");
	}
	public void startTest(String methodName)	{
	//test = report.startTest(Thread.currentThread().getClass().getSimpleName() );
		test = report.startTest(methodName );
	}
	public void starttest(String classname)	{
		String str = getCurrentTime();
	report = new ExtentReports("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-proj\\test-output\\ExtentReportResults_"+ str + ".html");
	//test = report.startTest("ExtentDemo");
	test = report.startTest(classname );
	}
	

	
	public void endTest(){
	report.endTest(test);
	report.flush();
	}

	public static String getCurrentTime() {
		String str = "";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
			LocalTime currentTime = LocalTime.now();
			str = currentTime.format(formatter);
			return str;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String getCurrentMonth() {
		String str = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMM");
			Date d = new Date();	
			str = dateFormat.format(d);
			return str;
		} catch (Exception e) {
			return "";
		}
	}
	
	
	
	public void click(WebElement element) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error.. " + e.getMessage());
		}
	}

	public void clear(WebElement element) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error.. " +  e.getMessage());
		}
	}
	
	public String getCurrentDate() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		String str  ="";
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			Date d = new Date();	
			str = dateFormat.format(d);
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error.. " + e.getMessage());
		}
		return str;
	}
	
	
	public String getCurrentYear() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		String str  ="";
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Date d = new Date();	
			str = dateFormat.format(d);
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error.. " + e.getMessage());
		}
		return str;
	}
	
	public int getCurrentyear() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		int ret = 0;
		try {
			Calendar cal =Calendar.getInstance();
			ret = cal.YEAR;
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error.. " + e.getMessage());
		}
		return ret;
	}
	
	public void geturl(String url) {
		driver.get(url);
	}
	
	public void wait(int waittime) {
		try {
			Thread.sleep(waittime * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lanuch_driver() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+ "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running.. ");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-proj\\src\\main\\java\\base\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	public String getCurrentUrl() {
		String ret = driver.getCurrentUrl();
		return ret;
	}
	
	public void sync() {
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		final  JavascriptExecutor js = (JavascriptExecutor)driver;

		    // wait for jQuery to load
		    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver driver) {
		        try {
		          return ((Long)js.executeScript("return jQuery.active") == 0);
		        }
		        catch (Exception e) {
		          return true;
		        }
		      }
		    };

		    // wait for Javascript to load
		    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver driver) {
		        return js.executeScript("return document.readyState")
		            .toString().equals("complete") || js.executeScript("return document.readyState")
		            .toString().equals("interactive");
		      }
		    };

		  wait.until(jQueryLoad);
		  wait.until(jsLoad);
	}

	 public void waitUntilAngularFinishHttpCalls() {
	        final String javaScriptToLoadAngular =
	                "var injector = window.angular.element('body').injector();" + 
	                "var $http = injector.get('$http');" + 
	                "return ($http.pendingRequests.length === 0)";

	        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
	            }
	        };
	        WebDriverWait wait = new WebDriverWait(driver, 20); // timeout = 20 secs
	        wait.until(pendingHttpCallsCondition);
	    }
	 
	public void getScreenShot() {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(screenshotFile, new File("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-cucumber\\test-outout\\screenshot\\" + System.currentTimeMillis()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getScreenShotOfElement(WebElement element) {
		File screenshotFile = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(screenshotFile, new File("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-cucumber\\test-outout\\screenshot\\" + System.currentTimeMillis()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getXpath(WebElement element) {
		
		String strlist[] = null;
		String by = null;
		String value = null;
		
		try {
			String str = element.toString();
			System.out.println(str);
			strlist = str.split("->");
			
			if (strlist.length > 1) {
				str = strlist[1];
				by = str.split(":", 2)[0].trim();
				value = str.split(":", 2)[1].trim();
				value = value.substring(0, value.length()-1);
			}
			else {
				str = str.split("By.")[1];
				by = str.split(":", 2)[0].trim();
				value = str.split(":", 2)[1].trim();
				value = value.substring(0, value.length()-1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return by + "~" + value;
		
	}
	public void waitForElementToBePresent(WebElement element  ) {
		try {
			String xpath = getXpath(element);
			String by = xpath.split("~")[0];
			String value = xpath.split("~")[1];
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			switch (by) {
			case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));			
				break;
			case "name": wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));			
			break;
			case "className": wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));			
			break;
			case "xpath": wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));			
			break;
			case "css": wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));			
			break;
			case "tagName": wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));			
			break;
			case "linkText": wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));			
			break;
			case "partialLinkText": wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(value)));			
			break;
			
			}
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			for (int i = 1; i < 30; i++) {
				if (!element.isDisplayed()) {
					this.wait(1);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}
	
	public void waitForElementToDisappear(WebElement element  ) {
		try {
			String xpath = getXpath(element);
			String by = xpath.split("~")[0];
			String value = xpath.split("~")[1];
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			switch (by) {
			case "id": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));			
				break;
			case "name": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(value)));			
			break;
			case "className": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(value)));			
			break;
			case "xpath": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));			
			break;
			case "css": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(value)));			
			break;
			case "tagName": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(value)));			
			break;
			case "linkText": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(value)));			
			break;
			case "partialLinkText": wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(value)));			
			break;
			
			}
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			for (int i = 1; i < 30; i++) {
				if (!element.isDisplayed()) {
					this.wait(1);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}
	
	
	public void teardown() {
		driver.quit();
	}

	public void scrollInToView(WebElement element) {
		
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			wait(1/2);
		} catch (Exception e) {
			try {
				Actions actions = new Actions(driver);
				actions.moveToElement(element);
				actions.perform();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		
	}

	public ArrayList<String> getDropdownAllValues(WebElement element) {
		ArrayList<String> allOptions = new ArrayList<>();
		try {
			Select select = new Select(element);
			List<WebElement> options  =select.getOptions();
			for (WebElement option : options) {
				allOptions.add(option.getText());
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return allOptions;
	}
	
	public String getAttribute(WebElement element, String attribute) {
		String atribValue = element.getAttribute(attribute);
		return atribValue;
		
	}

	public boolean elementIsDisplayed(WebElement element) {
	
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean elementIsEnabled(WebElement element) {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean elementIsSelected(WebElement element) {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void selectDropdownByValue(WebElement element, String value) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " is running");
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			try {
				Select select = new Select(element);
				select.selectByVisibleText(value);
			} catch (Exception e2) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error " + e2.getMessage());
			}	
		}
		
	}

	public String getSelectedDropdownText(WebElement element) {
		String str ="";
		if (element.isDisplayed()) {
			Select select = new Select(element);
			WebElement option =select.getFirstSelectedOption();
			str = option.getText();
			return str;
		} else {
			return str;
		}
	}

	public String getText(WebElement element) {
		String str = "";
		if (str.equals("")) {
			try {
				str=  element.getText();
				return str;
			} catch (Exception e) {
				return "";
			}
		} else {
			try {
				str=  element.getAttribute("innerHTML");
				return str;
			} catch (Exception e) {
				return "";
			}
		}
	}
	
	public void mouseHoverOnElement(WebElement element) {     
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			Actions actions = new Actions(driver);     
		     actions.moveToElement(element).perform();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
	}
	
	
	public void switchToFrame(WebElement frame) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			driver.switchTo().frame(frame);
		} catch (Exception e) {
			try {
				driver.switchTo().frame(0);
			} catch (Exception e2) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e2.getMessage());
			}
		}
	}
	
	
	public void switchToDefaultContent() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
	}
	public void get(String url) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			driver.get(url);;
		} catch (Exception e) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
		
	}
	public void closebrowser() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			driver.quit();
		} catch (Exception e) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
	}

	public void closeAlert() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
	}
	
	public String getAlertText() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is running...");
		String str = "";
		try {
			str = driver.switchTo().alert().getText();
		} catch (Exception e) {
				System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " is throwing error..." + e.getMessage());
		}
		return str;
	}
	
}


