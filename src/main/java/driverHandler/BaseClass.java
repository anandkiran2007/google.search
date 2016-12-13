package driverHandler;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	public ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();
	private static Properties prop = new Properties();

	@BeforeSuite(alwaysRun = true)
	@Parameters("config-file")
	public static void configLoader(String configfile) throws IOException{
		FileInputStream  conf = new FileInputStream(configfile);
		prop.load(conf);
	}

	@BeforeClass
	@Parameters({"browserName","OS"})
	public void initDriver(String browserName,String OS) throws Exception {
		String browser = browserName;
		Platform osPlatform;
		if(OS.equals("MAC")){
			osPlatform = Platform.MAC;
		}else{
			osPlatform = Platform.WINDOWS;
		}
		RemoteWebDriver driver = null;
		new DesiredCapabilities();
		if(browser.toLowerCase().equals("firefox")) {
			DesiredCapabilities capability = DesiredCapabilities.firefox(); 
			capability.setBrowserName("firefox");
			capability.setCapability("marionette", false);
			capability.setPlatform(osPlatform);
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		} else if(browser.toLowerCase().equals("chrome")) {
			DesiredCapabilities capability = DesiredCapabilities.chrome(); 
			capability.setBrowserName("chrome");
			capability.setPlatform(osPlatform);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		setWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	public WebDriver getDriver() {
		return remoteDriver.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		remoteDriver.set(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		getDriver().quit();
		remoteDriver.set(null);
	}
}
