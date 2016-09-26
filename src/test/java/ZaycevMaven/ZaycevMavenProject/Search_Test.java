package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.Test;

public class Search_Test extends BaseTest{

	
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
