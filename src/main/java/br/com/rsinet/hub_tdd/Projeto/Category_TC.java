package br.com.rsinet.hub_tdd.Projeto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Pesquisa_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Category_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Category_TC {

private static ChromeDriver driver;
	
	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca pela home");
		driver = new ChromeDriver();
		Reporter.log("Abrindo o navegador");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iniciaTest() throws Exception {
		driver.get("https://www.advantageonlineshopping.com/");
		Reporter.log("Acessando a loja");
		Category_Action.Execute_BuscaHome(driver);
		Reporter.log("Executando a busca de produto pela home");
	
	}
	@AfterClass
	public static void fechaNavegador() {
		driver.quit();
		Reporter.log("Fechando o navegador");
	}
}
