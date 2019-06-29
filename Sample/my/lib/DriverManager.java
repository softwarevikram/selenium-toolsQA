package my.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	
	private static WebDriver driver = null;
	String browser = "chrome";	//can get from properties file or .xls file
	
	WebDriver setDriver() throws Exception{
		String workingDir = System.getProperty("user.dir");
		String driversDir = workingDir + "\\drivers";
		
		switch(this.browser){
		case "ff": case "firefox": case "mozilla":
			driver = new FirefoxDriver();
			break;
		case "gc": case "chrome": case "googlechrome":
			String chromeDriverPath = driversDir + "\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case "ie": case "internetexplorer":
			String ieDriverPath = driversDir + "\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ieDriverPath);
			driver = new InternetExplorerDriver();		
			break;
		default:
			throw new Exception("Check the broswer name!");				
		}
			
			return driver;		
	}
	
	protected WebDriver getDriver(){
		if(driver != null){
			return driver;
		}else{
			try {
				driver = this.setDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return driver;
		}		
	}

}
