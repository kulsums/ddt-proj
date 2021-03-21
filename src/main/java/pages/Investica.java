package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Investica extends TestBase {

	@FindBy (xpath = "//a[text()='Login']")
	public WebElement login_link;
	
	@FindBy (id ="username")
	public WebElement user_text;
	
	@FindBy (id ="password")
	public WebElement pwd_text;
	
	@FindBy (xpath ="//button[text()='Login']")
	public WebElement login_btn;
	
	@FindBy (xpath ="//input[@id='username']/following-sibling::label")
	public WebElement user_label;
	
	@FindBy (xpath ="//input[@id='password']/following-sibling::label")
	public WebElement pwd_label;
	
	@FindBy (css = ".modal-body.text-center>p")
	public WebElement error_text;
	
	@FindBy (xpath = "//button[text()='CLOSE']")
	public WebElement close_btn_login;
	
	@FindBy (xpath = "//span[text()='Required']")
	public WebElement required;
	
	/**************************************** Schema Profile page elements ****************************************************************/
	
	@FindBy (id ="searchIcon")
	public WebElement search_icon;
	
	@FindBy (id ="example-search-input")
	public WebElement search_input;
	
	@FindBy (id ="search-btn")
	public WebElement search_btn;
	
	@FindBy (xpath ="//*[@id=\"style-7\"]/div/div/h5[1]/a")
	public WebElement search_first_Suggestion;
	
	@FindBy (tagName = "h1")
	public WebElement Suggestion_header;	
	
	@FindBy (xpath = "//div[contains(@class, 'auto-search')][1]/div")
	public WebElement Suggestion_nodata;
	
	@FindBy (id ="hide")
	public WebElement close_search;
	
	public Investica() {
		PageFactory.initElements(driver, this);
	}
}
