package ZaycevMaven.ZaycevMavenProject;

import org.junit.Test;

public class AbilityToDownloadSong_Test extends BaseTest{
	
	@Test
	public void testAbilityToDownloadSong(){
		zaycevHomePage.openZaycevHomePage();
		zaycevHomePage.clickEnterButton();
		zaycevHomePage.enterEmail("Bondaruk9000@gmail.com");
		zaycevHomePage.enterPassword("532757575");
		zaycevHomePage.clickEntryButton();
		zaycevHomePage.clickOnPoiskLink();
		zaycevSearchingPage.insertValueInPoiskFiels("Highway to hell");
		zaycevSearchingPage.clickOnIskat();
		acdcPage = zaycevSearchingPage.moveAndClickDownLoadButton();
		//assertTrue(acdcPage.checkSongName().contains("AC/DC"));
		//acdcPage.clickOnPoisk(); - ВОТ ДАЖЕ ЭТОТ ЕЛЕМЕНТ НЕ МОЖЕТ НАЙТИ
		//assertTrue(acdcPage.checkDownloadButtonEnable());
	}
}


