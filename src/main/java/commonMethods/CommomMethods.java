package commonMethods;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommomMethods {

	private WebDriver driver;

	public CommomMethods(WebDriver driver){
		this.driver = driver;
	}

	public void goToPage(String url){
		System.out.println("Launching url ="+ url);
		try{
			driver.get(url);
		}catch(NotFoundException ex){
			System.out.println("Url not found"+ url);
		}catch(Exception ex){
			System.out.println("Url invalid"+ url);
		}
	}

	// This is the method which waits until an object is visible or waits to the maxmimum of 15 seconds. 
	// Similar to _isVisible in Sahi
	public void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForPageLoad() {
		System.out.println("waiting for page load");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public void enterText(WebElement webElement,String text){
		try{
			webElement.sendKeys(text);
			System.out.println("Entered the text in element =" + webElement);
		}catch(ElementNotVisibleException ex){
			System.out.println("WebElement" + webElement + "is not found");
		}catch(Exception ex){
			System.out.println("Element not found" + ex);
		}
	}
	
	public boolean isElementDisplayed(WebElement webElement){
		boolean isDisplayed = false;
		try{
			isDisplayed = webElement.isDisplayed();
			System.out.println("Element is displayed =" + webElement);
		}catch(ElementNotVisibleException ex){
			System.out.println("Element is not displayed =" + webElement);
		}catch(Exception ex){
			System.out.println("Element not found" + ex);
		}
		return isDisplayed;
	}
	
	public void click(WebElement webElement){
		try{
			webElement.click();
			System.out.println("Clicked on element =" + webElement);
		}catch(ElementNotVisibleException ex){
			System.out.println("WebElement" + webElement + "is not found");
		}catch(Exception ex){
			System.out.println("Element not found" + ex);
		}
	}
	
	public String getText(WebElement webElement){
		String text=null;
		try{
			System.out.println("Getting text");
			text = webElement.getText();
		}catch(ElementNotVisibleException ex){
			System.out.println("WebElement" + webElement + "is not found");
		}catch(Exception ex){
			System.out.println("Element not found" + ex);
		}
		return text;
	}
}
