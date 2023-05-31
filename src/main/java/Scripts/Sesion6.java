package Scripts;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Poms.TAP;

public class Sesion6 {
	
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
		TAP tap = new TAP(driver);
		//GooglePage gp = new GooglePage(driver);
		Thread.sleep(3000);
		//gp.typeOnSearchBar("test automation practice");
		//gp.clickResultById(1);
		driver.get("https://testautomationpractice.blogspot.com/");
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		tap.clickWikipediaIcon();
		ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		driver.get("https://www.google.com/");
		driver.switchTo().window(tab2.get(2));
		driver.get("https://www.youtube.com/");
		driver.switchTo().window(tab2.get(3));
		driver.get("https://www.amazon.com.mx/");
		driver.switchTo().window(tab2.get(4));
		driver.get("https://www.mercadolibre.com.mx/");
		//System.out.println(driver.getTitle());
		tap.selectWindowByName("Google");
	}
}
