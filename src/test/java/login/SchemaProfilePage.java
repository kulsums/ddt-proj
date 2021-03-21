package login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Investica;
import util.WebBrowser;
import util.extent_reporting;

public class SchemaProfilePage extends TestBase {
    
	WebBrowser activebrwser = new WebBrowser();
	Investica demo;
	
	@BeforeMethod
	public void setup() {
		init();
		activebrwser.get("https://investica.com/");
		activebrwser.sync();
		//extent_reporting.initializeTestcase(Thread.currentThread().getStackTrace()[1].getMethodName());
		demo = new Investica();
	}
	
	@Test(priority = 1)
	public void Verify_presence_of_search_icon_on_home_page() {
		extent_reporting.initializeTestcase("Verify_presence_of_search_icon_on_home_page");
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				Assert.assertTrue(true);
				extent_reporting.executeReport("Verify presence of search icon", "PASS");
			}
			
		} catch (Exception e) {
		
		}
	}
	/*
	@Test(priority = 2)
	public void Verify_placeholder_text_search_box() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				String placeholder = activebrwser.getAttribute(demo.search_input, "placeholder");
				if (placeholder.equals("Enter first 3 characters to search a scheme ")) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test(priority = 3)
	public void Verify_user_input() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				String userinput = "hdfc";
				activebrwser.sendKeys(demo.search_input, userinput);
				String actualValue = activebrwser.getText(demo.search_input);
				if (userinput.equals(actualValue)) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test(priority = 4)
	public void Verify_result_selection() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "hdfc");
				activebrwser.wait(3);
				activebrwser.click(demo.search_first_Suggestion);
				activebrwser.wait(2);
				if (activebrwser.elementIsDisplayed(demo.Suggestion_header)) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test (priority = 5)
	public void Verify_invalid_input() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "12th");
				activebrwser.wait(2);
				String searchVal = activebrwser.getText(demo.Suggestion_nodata);
				if (searchVal.contains("No Data Found")) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test (priority = 6)
	public void Verify_close_Search() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "random data");
				activebrwser.wait(2);
				activebrwser.click(demo.close_search);
				if (activebrwser.elementIsDisplayed(demo.search_icon)) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test (priority = 7)
	public void Verify_invalid_input_1_char() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "h");
				if (!activebrwser.elementIsDisplayed(demo.Suggestion_nodata)) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
	@Test (priority = 8)
	public void Verify_invalid_input_2_char() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "hd");
				if (!activebrwser.elementIsDisplayed(demo.Suggestion_nodata)) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	

	@Test (priority = 9)
	public void Verify_invalid_input_specialChar() {
		try {
			if (activebrwser.elementIsDisplayed(demo.search_icon)) {
				activebrwser.click(demo.search_icon);
				activebrwser.sendKeys(demo.search_input, "**fc");
				activebrwser.wait(2);
				String searchVal = activebrwser.getText(demo.Suggestion_nodata);
				if (searchVal.contains("No Data Found")) {
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
		
		}
	}
	
*/	
	@AfterMethod
	public void teardownend() {
		activebrwser.closebrowser();
	}
}
