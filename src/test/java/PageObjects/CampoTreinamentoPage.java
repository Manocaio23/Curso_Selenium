package PageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class CampoTreinamentoPage {

	private static final String URL = "file:///C:\\Users\\caio.cavalcante\\Downloads\\8.2 campo_treinamento\\componentes.html";
	private WebDriver driver;
	private WebDriver element;


	
	public CampoTreinamentoPage(WebDriver driver) {
		this.driver= driver;
	}
	
	
	public void acessarPagina() {
		driver.get(URL);

	}
	
	public void PreencherNome(String string) {
		driver.findElement(By.id("elementosForm:nome")).sendKeys(string);
	}
	
	public void PreencherSobrenome(String string) {
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(string);
	}
	
	public void Masculino(String string) {

		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		//verifica se est� realmente clicado 
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
	}
	
	public void SelecionarComida() {
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
	}
	
	public void escolaridade(String string) {
		
		WebElement element=driver.findElement(By.id("elementosForm:escolaridade"));
		Select select= new Select(element);
		select.selectByValue(string);
		//Assert.assertEquals(string, );
//		List<WebElement> options=select.getOptions();
//		Assert.assertEquals(8, options.size()); //verifique que 8 � o tamanho da minha opera��o
//		
//		//check que uma terminada opera��o est� no select
//		boolean encontrou = false;
//			for(WebElement option: options ) {
//				if(option.getText().equals(string)) {
//					encontrou = true;
//					break;
//				}
//			}
//			Assert.assertTrue(encontrou);
			
	}
	
	public void Esportes(String natacao, String futebol) {
		WebElement element=driver.findElement(By.id("elementosForm:esportes"));
		Select select= new Select(element);
		select.selectByVisibleText(natacao);
		select.selectByVisibleText(futebol);
		//valida��o - retorna uma lista o valor esperado s�o 2 valores e o atual � a busca que eu fiz com o tamanho
		List<WebElement>allSelectedOptions = select.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	public void TextArea(String texto) {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(texto);
	}
	
	public void ClickBotao() {
		WebElement botao=driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	public void EncontrarLink() {
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		//Assert.fail(); - falha o teste
		
	}
	
	public void EncotnrarTextosNaPagina() {
		// o get text tranforma em string o texto
		Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
	}
	
	public void JanelaSimples() {
		// abre o alert e depois fecha
		driver.findElement(By.id("alert")).click();
		Alert alert =driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		
		
	}
	
	public void JanelaConfirm() {
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert2.getText());
		alert2.dismiss();
		Assert.assertEquals("Negado", alert2.getText());
		alert2.dismiss();
		
		

	
	}
	
	public void AlertPrompt() {
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("23");
		alert.accept();
		Assert.assertEquals("Era 23?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
	}
	
	public void Valida��oCadastro() {
	WebElement botao =driver.findElement(By.id("elementosForm:cadastrar"));
	botao.click();
	Assert.assertEquals("Cadastrado!", botao.findElement(By.xpath("//*[@id=\'resultado\']/span")).getText());
	Assert.assertEquals("Nome: Caio", driver.findElement(By.id("descNome")).getText());
	Assert.assertEquals("Sobrenome: Augusto", driver.findElement(By.id("descSobrenome")).getText());
	Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
	Assert.assertEquals("Comida: Frango Pizza", driver.findElement(By.id("descComida")).getText());
	Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
	Assert.assertEquals("Esportes: Natacao Futebol", driver.findElement(By.id("descEsportes")).getText());
	Assert.assertEquals("Sugestoes: teste,teste", driver.findElement(By.id("descSugestoes")).getText());
	
	
	}
	
	public void Frames() {
		//ele entra primeiro no frame pra depois clicar no botao
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert= driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
	}
	
	public void abriPopup() {
		driver.findElement(By.xpath("//*[@id=\"buttonPopUpEasy\"]")).click();
		//driver.switchTo().window("Popup");
		//driver.findElement(By.tagName("textarea")).sendKeys("E a� ziziba?");
		//driver.close();
		//driver.switchTo().window("");
		
	}
	
	public void fechaNavegador() {
		driver.quit();
	}
	}
	
	
	
	

