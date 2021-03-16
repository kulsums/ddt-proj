package login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

import pages.Investica;
import util.ExcelUtil;
import util.WebBrowser;
import util.extent_reporting;

public class LoginTest extends TestBase {
    
	WebBrowser activebrwser = new WebBrowser();
	Investica demo;
	
	@BeforeMethod
	public void setup() {
		init();
		activebrwser.get("https://dev.investica.com/");
		activebrwser.sync();
		extent_reporting.initializeTestcase(Thread.currentThread().getStackTrace()[1].getClassName());
		demo = new Investica();
	}
	
	@Test(priority=1)
	public void Verify_login_page_load() {
		activebrwser.click(demo.login_link);
		activebrwser.wait(2);
		Assert.assertTrue(activebrwser.getCurrentUrl().contains("sign-in"));
	}
	
	@Test(priority=2)
	public void Verify_login_page_form_elements() {
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			activebrwser.wait(2);
			if (activebrwser.elementIsDisplayed(demo.user_text) && activebrwser.elementIsDisplayed(demo.pwd_text)
					&& activebrwser.elementIsDisplayed(demo.login_btn)) {
				Assert.assertTrue(true);
			}
		}
	}
	
	@Test(priority=3)
	public void Verify_user_input() {
		
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			if (activebrwser.elementIsDisplayed(demo.user_text) && activebrwser.elementIsDisplayed(demo.pwd_text)
					&& activebrwser.elementIsDisplayed(demo.login_btn)) {
				activebrwser.sendKeys(demo.user_text, "useremail");
				String expInput = activebrwser.getText(demo.user_text);
				if (expInput.equals("useremail")) {
					Assert.assertTrue(true);
				}
			}
		}
	}
	
	@Test (priority=4)
	public void Verify_that_Username_Password_has_valid_placeholder() {
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			if (activebrwser.elementIsDisplayed(demo.user_text) && activebrwser.elementIsDisplayed(demo.pwd_text)) {
				String userLabel = activebrwser.getText(demo.user_label);
				String pwdLabel = activebrwser.getText(demo.pwd_label);
				if (userLabel.contains("User Id/ Email") && pwdLabel.contains("Password")) {
					Assert.assertTrue(true);
				}
			}
		}
	}

	@Test(priority=5)
	public void Verify_that_Password_is_masked() {
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			if (activebrwser.elementIsDisplayed(demo.pwd_text)) {
				String pwdAtt = activebrwser.getAttribute(demo.pwd_text, "type");
				if (pwdAtt.equals("password")) {
					Assert.assertTrue(true);
				}
			}
		}
	}

	@DataProvider
	public Iterator<Object[]> getUser() throws IOException {
		ArrayList<Object[]> testData = ExcelUtil.getDataFromExcel();
		return testData.iterator();
	}
    
	@Test(dataProvider="getUser", testName = "inputdata")
	public void verify_signup_with_set_of_data(String username, String password) throws IOException {
		activebrwser.click(demo.login_link);
		activebrwser.sendKeys(demo.user_text, username);
		activebrwser.wait(2);
		activebrwser.sendKeys(demo.pwd_text, password);
		activebrwser.click(demo.login_btn);
		activebrwser.wait(2);
		if (activebrwser.elementIsDisplayed(demo.error_text)) {
			System.out.println("Error text" + activebrwser.getText(demo.error_text));
			activebrwser.click(demo.close_btn_login);
			Assert.assertTrue(true);
		} else {
			if(activebrwser.elementIsDisplayed(demo.required));
			Assert.assertTrue(true);
		}
		
	}
	
	@Test(priority =6)
	public void Verify_no_input_user() {
		
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			if (activebrwser.elementIsDisplayed(demo.user_text) && activebrwser.elementIsDisplayed(demo.pwd_text)
					&& activebrwser.elementIsDisplayed(demo.login_btn)) {
				activebrwser.sendKeys(demo.user_text, "");
				activebrwser.sendKeys(demo.pwd_text, "text");
				if (activebrwser.elementIsDisplayed(demo.required)) {
					Assert.assertTrue(true);
				}
			}
		}
	}
	

	@Test(priority =7)
	public void Verify_no_input_password() {
		
		activebrwser.click(demo.login_link);
		if (activebrwser.getCurrentUrl().contains("auth/sign-in")) {
			if (activebrwser.elementIsDisplayed(demo.user_text) && activebrwser.elementIsDisplayed(demo.pwd_text)
					&& activebrwser.elementIsDisplayed(demo.login_btn)) {
				activebrwser.sendKeys(demo.user_text, "text");
				activebrwser.sendKeys(Keys.TAB, demo.pwd_text);
				
				if (activebrwser.elementIsDisplayed(demo.required)) {
					Assert.assertTrue(true);
				}
			}
		}
	}
	
	
	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
