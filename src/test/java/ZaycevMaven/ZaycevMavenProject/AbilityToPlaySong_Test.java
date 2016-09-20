package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbilityToPlaySong_Test {
	
	WebDriver driver;
	ZaycevHomePage zaycevHomePage;
	ZaycevSearchingPage zaycevSearchingPage;
	AcdcPage acdcPage;
	
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", ".\\src\\libs\\geckodriver.exe");
		driver = new FirefoxDriver();
		zaycevHomePage = new ZaycevHomePage(driver);
		zaycevSearchingPage = new ZaycevSearchingPage(driver);
	}
	
	@After
	public void tearDown(){
		zaycevHomePage.closeBrowser();
	}
	
	@Test
	public void testAbilityToPlaySong(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("Bondaruk9000@gmail.com");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		zaycevHomePage.clickOnPoiskLink();
		zaycevSearchingPage.unchekMailChekbox();
		zaycevSearchingPage.insertValueInPoiskFiels("Highway to hell");
		zaycevSearchingPage.clickOnIskat();
		zaycevSearchingPage.clickPlayFirsSong();
		assertTrue(zaycevSearchingPage.checkPlainingFirstSong());
	}

}
