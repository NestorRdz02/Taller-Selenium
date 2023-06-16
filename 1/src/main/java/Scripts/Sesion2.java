package Scripts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Poms.GooglePage;

public class Sesion2 {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void test() throws InterruptedException{
		driver.get("https:/google.com");
		GooglePage gp = new GooglePage(driver);
		Thread.sleep(6000);
		//Búsqueda en google
		gp.typeOnSearchBar("Wikipedia");
		//Click en primer resultado
		Thread.sleep(1000);
		gp.clickResultById(1);
		gp.printTitle();
		gp.printPar();
	}
}