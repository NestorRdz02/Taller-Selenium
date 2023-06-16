package Poms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon {

	WebDriver driver;
	String searchBarId = "APjFqb";
	String resultsClass = "//h3[@class='LC20lb MBeuO DKV0Md']";
	String searchBarIdAZ = "twotabsearchtextbox";
	String clickSamsumg = "//*[@id=\"p_89/SAMSUNG\"]/span/a/div";
	String clickAndroid11 = "//*[@id=\"p_n_feature_twenty-two_browse-bin/36756470011\"]/span/a/span";
	String clickAndroid12 = "//*[@id=\"p_n_feature_twenty-two_browse-bin/36756462011\"]/span/a/span";
	String ordenarXpath = "//*[@id=\"search\"]/span/div/h1/div/div[2]/div/div/form/span";
	String ordenarMenorMayorXpath = "//*[@id=\"a-popover-2\"]/div/div/ul/li[2]";
	String name = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[2]/div[2]/h2/a/span";
	String price = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[2]/div[4]/div[2]/a/span/span[2]/span[2]";

	public Amazon(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void typeOnSearchBar( String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public void clickResultById(int result) {
		List <WebElement> list = driver.findElements(By.xpath(resultsClass));
		list.get(result).click();
	}
	
	public void typeOnSearchBarAZ( String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarIdAZ));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public void clickSortByPrice() {
	    WebElement sortBy = driver.findElement(By.xpath(ordenarXpath));
	    sortBy.click();
	    WebElement sortByPriceLowToHigh = driver.findElement(By.xpath(ordenarMenorMayorXpath));
	    sortByPriceLowToHigh.click();
	}
	
	public void printName() {
		WebElement cellphoneName = driver.findElement(By.xpath(name));
		System.out.println(cellphoneName.getText());
	}
	
	public void clickOperativeSystem() {
		WebElement button = this.driver.findElement(By.xpath(this.clickAndroid11));
		button.click();
		WebElement button1 = this.driver.findElement(By.xpath(this.clickAndroid12));
		button1.click();
	}
	
	public void printLowestPrice() {
		WebElement lowerPrice = driver.findElement(By.xpath(price));
		System.out.println("$"+lowerPrice.getText());
	}
	
	public void clickBrand() {
		WebElement button = this.driver.findElement(By.xpath(this.clickSamsumg));
		button.click();
	}
	
	

}