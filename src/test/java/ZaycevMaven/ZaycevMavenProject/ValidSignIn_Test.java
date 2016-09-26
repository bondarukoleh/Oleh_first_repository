package ZaycevMaven.ZaycevMavenProject;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidSignIn_Test extends BaseTest{
	
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
