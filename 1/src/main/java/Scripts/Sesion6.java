package Scripts;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
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
	public void test() throws InterruptedException{
		/*driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		Thread.sleep(3000);
		gp.typeOnSearchBar("test automation practice");
		gp.clickResultById(0);
		tap.clickAlertButton();*/
		driver.get("https://testautomationpractice.blogspot.com/");
		TAP tap = new TAP(driver);
		tap.clickWIcon();
		ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(driver.getTitle());
		driver.switchTo().window(tab2.get(1));
		System.out.println(driver.getTitle());
		driver.get("https://www.google.com/");
		driver.switchTo().window(tab2.get(2));
		driver.get("https://www.youtube.com/");
		driver.switchTo().window(tab2.get(3));
		driver.get("https://www.amazon.com.mx/");
		driver.switchTo().window(tab2.get(4));
		driver.get("https://www.mercadolibre.com.mx/");
		tap.selectWindowName("Google");
	}
}
