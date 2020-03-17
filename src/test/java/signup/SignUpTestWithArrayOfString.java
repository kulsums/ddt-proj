package signup;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import junit.framework.Assert;
import pages.DemoBlaze;
import util.ExcelUtil;
import util.WebBrowser;
import util.extent_reporting;

public class SignUpTestWithArrayOfString extends TestBase {
    
	WebBrowser activebrwser = new WebBrowser();
	DemoBlaze demo;
	
	@BeforeMethod
	public void setup() {
		init();
		activebrwser.get("https://www.demoblaze.com/");
		activebrwser.sync();
		extent_reporting.initializeTestcase(Thread.currentThread().getStackTrace()[1].getClassName());
		demo = new DemoBlaze();
	}
	
	@DataProvider
	public  String[][] getUser() throws IOException {
		String[][] data = ExcelUtil.getUserName("login");
		return data;
	}
    
	@Test(dataProvider="getUser")
	public void verify_signup_with_set_of_data(String username, String password) throws IOException {
		activebrwser.click(demo.signup_link , "Activate signup link on homepage");
		activebrwser.wait(1);
		activebrwser.sendKeys(demo.user_text, username , "Enter user name as " + username);
		activebrwser.wait(3);
		activebrwser.sendKeys(demo.pwd_text, password, "Enter password to password field");
		activebrwser.click(demo.signUp_btn , "Click on signup button post entering data");
		
		//activebrwser.closeAlert();
		activebrwser.wait(2);
		String alerttext = activebrwser.getAlertText();
		Assert.assertTrue(alerttext.contains("Sign up successful.") || alerttext.contains("This user already exist."));
	}
	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
