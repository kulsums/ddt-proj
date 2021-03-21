package login;

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

public class AboutUsTest extends TestBase {
    
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
	public void verify_about_us_modal_is_displayed() throws IOException {
		activebrwser.click(demo.aboutus, "Click link about us");
		Assert.assertTrue(activebrwser.elementIsDisplayed(demo.aboutusheading));
	}
	
	@Test
	public void verify_user_is_able_to_close_about_us_modal() throws IOException {
		activebrwser.click(demo.aboutus, "Click link about us");
		if (activebrwser.elementIsDisplayed(demo.aboutusheading)) {
			activebrwser.click(demo.closeaboutus_btn, "Close about us modal");
			if (!activebrwser.elementIsDisplayed(demo.closeaboutus_btn)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}
	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
