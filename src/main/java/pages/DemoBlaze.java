package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DemoBlaze extends TestBase {

	@FindBy (id = "signin2")
	public WebElement signup_link;
	
	@FindBy (id ="sign-username")
	public WebElement user_text;
	
	@FindBy (id ="sign-password")
	public WebElement pwd_text;
	
	@FindBy (xpath ="//button[text()='Sign up']")
	public WebElement signUp_btn;
	
	
	/********************************************About us***************************************************/
	
	@FindBy (xpath="//a[text()='About us']")
	public WebElement aboutus;
	
	@FindBy (xpath="//h5[text()='About us']")
	public WebElement aboutusheading;
	
	@FindBy (xpath="//*[@id='videoModal']/div/div/div[3]/button")
	public WebElement closeaboutus_btn;
	
	public DemoBlaze() {
		PageFactory.initElements(driver, this);
	}
}
