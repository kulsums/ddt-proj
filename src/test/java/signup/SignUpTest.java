package signup;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DemoBlaze;
import util.ExcelUtil;
import util.WebBrowser;
import util.extent_reporting;

public class SignUpTest extends TestBase {
    
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
	public Object[][] getUser() throws IOException {
		Object data[][] = ExcelUtil.getUserName_("login");
		return data;
	}
    
	@Test(dataProvider="getUser")
	public void verify_signup_with_set_of_data(String username, String password) throws IOException {
		activebrwser.click(demo.signup_link);
		activebrwser.sendKeys(demo.user_text, username);
		activebrwser.wait(2);
		activebrwser.sendKeys(demo.pwd_text, password);
	}
	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
