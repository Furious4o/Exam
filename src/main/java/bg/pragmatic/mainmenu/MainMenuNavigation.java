package bg.pragmatic.mainmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bg.pragmatic.Exam.browser.Browser;
import bg.pragmatic.MyFirstTest.backend.common.WaitTool;

public class MainMenuNavigation {

	public static void logout(){
		Browser.driver.findElement(By.linkText("Logout")).click();
			
	}

	public static void catalogGoTo(String goToPage) {
		Actions builder = new Actions(Browser.driver);
		WebElement catalog = Browser.driver.findElement(By.linkText("Catalog"));
		switch(goToPage.toUpperCase()){
		
		
		case "PRODUCTS":
			
			builder.moveToElement(catalog).build().perform();
			WebElement products = WaitTool.waitForElement(Browser.driver, By.xpath("//a[contains(text(),'Products')]"), 10);
			products.click();
			break;
			
			
		//More navigation to be inserted below
		}

		
	}
	
	

}
