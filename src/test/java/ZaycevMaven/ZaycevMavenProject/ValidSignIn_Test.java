package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidSignIn_Test extends BaseTest{
	WebDriver driver;
	ZaycevHomePage zaycevHomePage;

	@Before
	public void setUp(){
		driver = getFFdriver();
		zaycevHomePage = new ZaycevHomePage(driver);
	}
	
	@After
	public void tearDown(){
		zaycevHomePage.closeBrowser();
	}
	
	@Test
	public void testValidSignIn(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("Bondaruk9000@gmail.com");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		assertTrue(zaycevHomePage.checkThatUserEntered().contains("Uncle_Bond"));
	}
}
