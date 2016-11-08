package bg.pragmatic.Exam;

import org.junit.Before;
import org.junit.Test;

import bg.pragmatic.Exam.browser.Browser;
import bg.pragmatic.mainmenu.MainMenuNavigation;

public class AdminLoginTests {

	@Before
	public void setUp(){
		Browser.init("chrome");
	}
	
	
	@Test
	public void successfulLogin(){
		AdminLogin.goTo();
		AdminLogin.login();
		//Browser.driver.navigate().refresh();
		AdminDashboard.verifyTitle("It was unable to verify the correct title", "Dashboard");
	
		
	}
	
	@Test
	public void insertNewProduct(){
		successfulLogin();
		MainMenuNavigation.catalogGoTo("PRoDuCtS");
		AdminCatalogProducts.verifyExistingProductAndInsert("ExamTestProductIlian");
		
	}
	
	
	
	/*@After
	public void tearDown(){
		Browser.quit();
	}*/
	
}
