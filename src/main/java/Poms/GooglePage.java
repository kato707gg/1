package Poms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	WebDriver driver;
	String searchBarId = "APjFqb";
	String Result = "//h3[text()='Wikipedia, la enciclopedia libre']";
	String titulo = "//*[@id=\"firstHeading\"]";
	String resultsClass = "//h3[@class='LC20lb MBeuO DKV0Md']";
	String resultsParagraphs = "//*[@id=\"mw-content-text\"]/div[1]/p";

	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public GooglePage() {
		
	}
	
	public void typeOnSearchBar( String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public void clickResult() {
		WebElement fr = driver .findElement(By.xpath(Result));
		fr.click();
	}
	
	public void printResult() {
		WebElement fr = driver .findElement(By.xpath(titulo));
		System.out.println(fr.getText());
	}
	
	public void clickResultById(int result) {
		List <WebElement> list = driver .findElements(By.xpath(resultsClass));
		list.get(result).click();
	}
	
	public void printTitle() {
		System.out.println(driver.getTitle());
	}
	
	public void printResults() {
		List <WebElement> list = driver .findElements(By.xpath(resultsClass));
		for(WebElement element: list) {
			System.out.println(element.getText());
		}
	}
	
	public void printParagraphs() {
	    List<WebElement> list = driver.findElements(By.xpath(resultsParagraphs));
	    int counter = 0;
	    for (WebElement element : list) {
	        System.out.println(element.getText());
	        counter++;
	        if (counter >= 4) {
	            break;
	        }
	    }
	}
}
