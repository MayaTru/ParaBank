package testComponent;

import org.maya.TestParam.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {
	WebDriver driver;
	
	public WebDriver initDriver() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		return driver;
	}
	
	public LandingPage launchApp(String url) {
		driver = initDriver();
		LandingPage obj = new LandingPage(driver);
		obj.goTo(url);
		return obj;
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(6000);
		driver.quit();
	}
}
