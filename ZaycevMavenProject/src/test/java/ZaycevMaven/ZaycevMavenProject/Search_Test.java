package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search_Test {
	
	WebDriver driver;
	ZaycevHomePage zaycevHomePage;
	ZaycevSearchingPage zaycevSearchingPage;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		zaycevHomePage = new ZaycevHomePage(driver);
		zaycevSearchingPage = new ZaycevSearchingPage(driver);
	}
	
	@After
	public void tearDown(){
		zaycevHomePage.closeBrowser();
	}
	
	@Test
	public void testSearchTest(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("Bondaruk9000@gmail.com");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		zaycevHomePage.clickOnPoiskLink();
		zaycevSearchingPage.unchekMailChekbox();
		zaycevSearchingPage.insertValueInPoiskFiels("Highway to hell");
		zaycevSearchingPage.clickOnIskat();
		assertTrue(zaycevSearchingPage.checkFirstSong().contains("AC/DC"));
	}

}
