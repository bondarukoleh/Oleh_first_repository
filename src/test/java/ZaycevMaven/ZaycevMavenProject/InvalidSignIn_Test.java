package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.Test;

public class InvalidSignIn_Test extends BaseTest{
	
	@Test
	public void notValidSignIn(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("NOT VALID EMAIL");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		zaycevBadCredentialsPage = zaycevHomePage.checkBadCredentialsMessagefromBCpage();
		assertTrue(zaycevBadCredentialsPage.checkBadCredentialsMessage().contains("Неверная почта"));
	}

}
