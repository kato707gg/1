package Scripts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Poms.GooglePage;
import Poms.TAP;

public class Sesion3 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void test() throws InterruptedException{
		driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		Thread.sleep(1000);
		gp.typeOnSearchBar("test automation practice");
		Thread.sleep(1000);
		gp.clickResultById(1);
		tap.clickAlertButton();
		Thread.sleep(2000);
		tap.acceptAlert();
		gp.printMessage();
		tap.clickAlertButton();
		Thread.sleep(2000);
		tap.cancelAlert();
		gp.printMessage();
	}
}