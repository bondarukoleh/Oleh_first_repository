package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvalidSignIn_Test {
	
	WebDriver driver;
	ZaycevHomePage zaycevHomePage;
	ZaycevBadCredentialsPage zaycevBadCredentialsPage;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		zaycevHomePage = new ZaycevHomePage(driver);
	}
	
	@After
	public void tearDown(){
		zaycevHomePage.closeBrowser();
	}
	
	@Test
	public void notValidSignIn(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("NOT VALID EMAIL");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		//zaycevHomePage.checkBadCredentialsMessage();
		//assertTrue(zaycevHomePage.checkBadCredentialsMessage().contains("Неверная"));
		
		zaycevBadCredentialsPage = zaycevHomePage.checkBadCredentialsMessagefromBCpage();
		assertTrue(zaycevBadCredentialsPage.checkBadCredentialsMessage().contains("Неверная"));
	}

}
