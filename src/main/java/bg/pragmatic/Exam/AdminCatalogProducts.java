package bg.pragmatic.Exam;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import bg.pragmatic.Exam.browser.Browser;
import bg.pragmatic.MyFirstTest.backend.common.WaitTool;


public class AdminCatalogProducts {

	
	public static void verifyExistingProductAndInsert(String productName){
		WebElement filterNameField = Browser.driver.findElement(By.name("filter_name"));
		filterNameField.sendKeys(productName);
		WebElement filterButton = Browser.driver.findElement(By.linkText("Filter"));
		filterButton.click();
		try{
		Browser.driver.findElement(By.xpath("//td[contains(text(), 'No results!')]"));
		insertProduct();
		} catch(NoSuchElementException e){
			for(int i=0; i< Browser.driver.findElements(By.name("selected[]")).size(); i++){
			deleteProduct();
			}
			insertProduct();
			
		
		}
		
	}
	
	public static void insertProduct(){
		WebElement insertButton = Browser.driver.findElement(By.linkText("Insert"));
		insertButton.click();
		WebElement productName = Browser.driver.findElement(By.name("product_description[1][name]"));
		productName.sendKeys("ExamTestProductIlian");
		WebElement menuDataButton = Browser.driver.findElement(By.linkText("Data"));
		menuDataButton.click();
		WebElement modelField = WaitTool.waitForElement(Browser.driver, By.name("model"), 10);
		modelField.sendKeys("ExamTestModelIlian");
		WebElement saveButton = Browser.driver.findElement(By.linkText("Save"));
		saveButton.click();
		Assert.assertEquals("Product was not created successfully", "Success: You have modified products!", Browser.driver.findElement(By.className("success")).getText());
		
	}
	
	public static void deleteProduct(){
		Assert.assertEquals("Element Not Found", "ExamTestProductIlian", Browser.driver.findElement(By.xpath("//td[contains(text(),'ExamTestProductIlian')]")).getText());
		WebElement checkboxDeleteAll = Browser.driver.findElement(By.xpath("//table[@class='list']/thead/tr/td/input[@type='checkbox']"));
		checkboxDeleteAll.click();
		WebElement deleteButton = Browser.driver.findElement(By.linkText("Delete"));
		deleteButton.click();
		Alert deleteAlert = Browser.driver.switchTo().alert();
		deleteAlert.accept();
		Assert.assertEquals("Product was not created successfully", "Success: You have modified products!", Browser.driver.findElement(By.className("success")).getText());
	}

	
	
	
}
