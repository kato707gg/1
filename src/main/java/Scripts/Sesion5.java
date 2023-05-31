package Scripts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Poms.Amazon;

public class Sesion5 {

private WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
		}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https:/www.google.com");
		Amazon Az = new Amazon(driver);
		Thread.sleep(2000);
		Az.typeOnSearchBar("Amazon");
		Thread.sleep(1000);
		Az.clickResultById(0);
		Az.typeOnSearchBarAZ("Celulares");
		Az.clickBrandButton();
		Az.clickOSButton();
		Thread.sleep(1000);
		Az.clickSortByPrice();
		Thread.sleep(1000);
		Az.printName();
		Thread.sleep(1000);
		Az.printLowerPrice();
	}
}