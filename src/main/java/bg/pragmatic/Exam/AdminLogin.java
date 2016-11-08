package bg.pragmatic.Exam;

import org.openqa.selenium.By;

import bg.pragmatic.Exam.browser.Browser;

public class AdminLogin {

	public static void goTo() {
		Browser.driver.get("http://shop.pragmatic.bg/admin");
		
	}

	public static void login() {
		Browser.driver.findElement(By.name("username")).sendKeys("admin");
		Browser.driver.findElement(By.name("password")).sendKeys("parola");
		Browser.driver.findElement(By.linkText("Login")).click();

		
	}

}
