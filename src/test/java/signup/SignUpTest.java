package signup;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    
	@Test
	public void verify_signup_with_set_of_data() throws IOException {
		activebrwser.click(demo.signup_link);
		String username = ExcelUtil.getUserName("login");
		activebrwser.sendKeys(demo.user_text, username);
		activebrwser.wait(4);
	}
	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
