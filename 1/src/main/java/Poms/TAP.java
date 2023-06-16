package Poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TAP {

	WebDriver driver;
	String alertButtonXpath = "//button[text()='Click Me']";
	String fileXpath = "//select[@name='files']";
	String speedXpath = "//select[@name='speed']";
	String numberXpath = "//select[@name='number']";
	String Icon = "//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[1]/a/img";
	
	public TAP(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickAlertButton() {
		
		WebElement button = this.driver.findElement(By.xpath(this.alertButtonXpath));
		button.click();
	}
	
	public void accept() {
		
		this.driver.switchTo().alert().accept();
	}
	
	public void cancel() {
		
		this.driver.switchTo().alert().dismiss();
	}
	
	public String selectCheckValue(String option) {
		String value = "";
		
		Select cb = new Select(this.driver.findElement(By.xpath(fileXpath)));
		List<WebElement> options = cb.getOptions();
		for(WebElement element: options) {
			String auxValue = element.getAttribute("value");
			if(auxValue.equals(option)) {
				value = element.getText();
			}
		}
		cb.selectByValue(option);
		return value;
	}
	
	public String selectCheckText(String option) {
		String value = "";
		Select cb = new Select(this.driver.findElement(By.xpath(speedXpath)));
		List<WebElement> options = cb.getOptions();
		for(WebElement element: options) {
			String auxValue = element.getAttribute("value");
			if(auxValue.equals(option)) {
				value = element.getText();
			}
		}
		cb.selectByVisibleText(option);
		return value;
	}
	
	public String selectCheckIndex(int option) {
	    String value = "";
	    Select cb = new Select(this.driver.findElement(By.xpath(numberXpath)));
	    List<WebElement> options = cb.getOptions();
	    if (option >= 0 && option < options.size()) {
	        WebElement element = options.get(option);
	        value = element.getText();
	    }
	    return value;
	}
	
	public void clickWIcon() {
	    WebElement wikipediaIcon = driver.findElement(By.xpath(Icon));
	    wikipediaIcon.click();
	}
	
	public void selectWindowName(String targetTitle) {
	    for (String windowHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(windowHandle);
	        String pageTitle = driver.getTitle();
	        if (pageTitle.equals(targetTitle)) {
	            return;
	        }
	    }
	}
}
