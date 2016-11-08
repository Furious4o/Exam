package bg.pragmatic.Exam;

import org.junit.Assert;

import bg.pragmatic.Exam.browser.Browser;

public class AdminDashboard {

	public static void verifyTitle(String messageOnFailure, String expectedMessage) {
		Assert.assertEquals(messageOnFailure, expectedMessage, Browser.driver.getTitle());
		
	}

	
		

}
