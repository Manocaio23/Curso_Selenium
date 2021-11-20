package Steps;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampoDeTreinamentoSteps {
	private WebDriver driver;
	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/caio.cavalcante/Downloads/Testes%20funcionais%20com%20Selenium%20WebDriver%20Do%20b%C3%A1sico%20ao%20GRID/3.%20Selenium%20Webdriver/Material/8.2%20campo_treinamento/componentes.html");
		driver.manage().window().maximize();
		
	}
}
