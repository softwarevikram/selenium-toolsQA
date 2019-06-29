package my.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumUtilities extends DriverManager {
	
	WebDriver driver;
	String url = "http://toolsqa.wpengine.com/automation-practice-form/";
	int implicitWaitTimeInSeconds = 30;			
	
	@BeforeTest(alwaysRun = true)
	protected void doPreTestActivity(){//param -> String url,int impWaitTime //(alwaysRun = true)
		System.out.println("Debug: preTest");
		this.driver = this.getDriver();
/*		launchBrowser(url);
		maximizeBrowserWindow();
		manageCookies();
		manageBrowserCapabilities();
		setImplicitWaitTime(implicitWaitTimeInSeconds);*/
	}
	
	@AfterTest(alwaysRun = true)
	protected void doPostTestActivity(){
		closeBrowser();
		quitDriver();
	}
	
	void quitDriver(){
		driver.quit();
	}
	
	void closeBrowser(){
		driver.close();
	}
	
	void launchBrowser(String url){
		driver.get(url);		
	}
	
	void maximizeBrowserWindow(){
		driver.manage().window().maximize();
	}
	
	void manageCookies(){
		clearCookies();		
	}
	
	void clearCookies(){
		driver.manage().getCookies().clear();
	}
	
	void manageBrowserCapabilities(){
		
	}
			
	void setImplicitWaitTime(int impWaitTime){
		driver.manage().timeouts().implicitlyWait(impWaitTime, TimeUnit.SECONDS);
	}
	
	protected WebDriverWait getExplicitWaitObj(int expWaitTime){
		return new WebDriverWait(driver, expWaitTime);
	}
	
	protected void clickOn(String locator) throws Exception{		
		findElementOnClickableState(locator).click();		
	}
	
	protected void setText(String locator, String textToSet) throws Exception{
		WebElement webElement = null;
		webElement = findElementOnClickableState(locator);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToSet);
	}

	public WebElement findElementOnClickableState(String locator) throws Exception
	{		
		String selector, selectorDesc = null;
		if(locator.contains("#")){
			String[] locatorParser = locator.split("#");
			selectorDesc = locatorParser[0].trim();
			selector = locatorParser[1].trim();
		}else{
			selector = locator;
		}

		try{
			return getExplicitWaitObj(60).until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));	
		}
		catch(Exception e){
			throw new Exception("Encountered problem with " + selectorDesc + ". And the exception caused: " + e.getMessage());
		}	
	}
}
