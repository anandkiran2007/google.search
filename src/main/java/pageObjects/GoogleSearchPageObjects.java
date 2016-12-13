package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonMethods.CommomMethods;

// This is the page objects class , which holds the property of each element of that page and corresponding methods 
// of the same page. 

// This is just an example derived using google search page 

// This is an example of page object model using Selenium wed driver with TestNG 

// Below Webelements are identifed using Selenium IDE / Firebug 
public class GoogleSearchPageObjects{

	@FindBy(name = "q")
	private WebElement googleSearch;

	@FindBy(name = "btnG")
	private WebElement searchButton;

	@FindBy(name = "btnK")
	private WebElement googleSearchButton;

	@FindBy(id="resultStats")
	private WebElement results;

	@FindBy(xpath="//h3[1]")
	private WebElement firstLinkHeading;

	@FindBy(xpath="//h3[2]")
	private WebElement secondLinkHeading;	

	CommomMethods commonMethods;
	//constructor with webdriver as parameter to initialize the class
	public GoogleSearchPageObjects(WebDriver driver) { 
		this.commonMethods = new CommomMethods(driver);
		//This line will initialize all the WebElement declared on the top 
		PageFactory.initElements(driver, this);
	}
	//This method is to launch the url in the browser.
	// Similar to _navigateTo in Sahi
	public void goTo(String url) {
		commonMethods.goToPage(url);
	}
	public String getResultResponseTime() {
		return commonMethods.getText(results);
	}
	//This method is used for performing the google search and print the time taken for the search
	public void googleSearch(String searchText) {
		commonMethods.enterText(googleSearch, searchText);
		if(commonMethods.isElementDisplayed(searchButton)) {
			commonMethods.click(searchButton);
		}
		else if(commonMethods.isElementDisplayed(googleSearchButton)) {
			commonMethods.click(googleSearchButton);
		}
		System.out.println(getResultResponseTime());
	}

	public void getFirstUrlTextInSearchResults(){
		commonMethods.getText(firstLinkHeading);
	}

	public void getSecondUrlTextInSearchResults(){
		commonMethods.getText(secondLinkHeading);
	}
}
