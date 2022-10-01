package gridexample;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample {
	RemoteWebDriver driver = null;
	String nodeUrl = "http://localhost:4444/wd/hub";

	@Parameters("port")
	@BeforeClass
	public void driverSetUp(String port) throws Exception {
		if (port.equals("4455")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability("browser", "Chrome");
			options.setCapability("platform", "WINDOWS");
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
		}

		if(port.equals("4457")){
			FirefoxOptions option = new FirefoxOptions();
			option.setCapability("browser", "FF");
			option.setCapability("useAutomationExtension", false);
			driver = new RemoteWebDriver(new URL(nodeUrl), option);
		}
		driver.get("file:///D:/Downloads/javabykiran-Selenium-Softwares/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkTitle(){
		
		Assert.assertEquals("JavaByKiran | Log in", driver.getTitle());
	}

}
