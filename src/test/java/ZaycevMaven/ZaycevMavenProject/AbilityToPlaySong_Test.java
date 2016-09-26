package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.Test;

public class AbilityToPlaySong_Test extends BaseTest{
	
	@Test
	public void testAbilityToPlaySong(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("Bondaruk9000@gmail.com");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		zaycevHomePage.clickOnPoiskLink();
		zaycevSearchingPage.insertValueInPoiskFiels("Highway to hell");
		zaycevSearchingPage.clickOnIskat();
		zaycevSearchingPage.clickPlayFirsSong();
		assertTrue(zaycevSearchingPage.checkPlainingFirstSong());
	}
}
