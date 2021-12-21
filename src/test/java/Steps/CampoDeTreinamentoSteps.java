package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import PageObjects.CampoTreinamentoPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampoDeTreinamentoSteps {
	private WebDriver driver;
	private CampoTreinamentoPage mc;
	private CampoTreinamentoPage mc2;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		mc=new CampoTreinamentoPage(driver);
		mc2=new CampoTreinamentoPage(driver);
	}
	
	
	@Given("que estou no campo de treinamento")
	public void que_estou_no_campo_de_treinamento() {
	   mc.acessarPagina();
	}
	
	@When("preencho {string} {string}")
	public void preencho(String nome, String sobrenome) {
	    mc.PreencherNome(nome);
	    mc.PreencherSobrenome(sobrenome);
	    
	}

	@When("seleciono {string} {string} {string}")
	public void seleciono(String sexo, String pizza, String frango) {
	    mc.Masculino(sexo);
	    mc.SelecionarComida();
	    
	}

	@When("depois seleciono {string}")
	public void depois_seleciono(String escolaridade) {
	    mc.escolaridade(escolaridade);
	}

	@When("seleciono {string} {string}")
	public void seleciono(String natacao, String futebol) {
	    mc.Esportes(natacao, futebol);
	}

	@When("escrevo {string}")
	public void escrevo(String string) {
	   mc.TextArea(string);
	   mc.ClickBotao();
	   mc.EncontrarLink();
	   mc.EncotnrarTextosNaPagina();
	   mc.JanelaSimples();
	   mc.JanelaConfirm();
	   
	   
	}

	@Then("devo visualizar o dados do cadatro")
	public void devo_visualizar_o_dados_do_cadatro() {
	   mc.ValidaçãoCadastro();
	   mc.Frames();
	  // mc.abriPopup();
	   mc.testaPrimeFaces();
	   mc.testaPrimeFacesSelect();
	   mc.PrimeFacesAjax();
	}
	
	@After
	public void fecha() throws IOException {
		//mc.tiraPrint();
		//mc.OutroPrint();
		mc.PrintY();
		//mc.fechaNavegador();
	}
	
}
