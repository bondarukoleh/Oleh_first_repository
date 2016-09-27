package ZaycevMaven.ZaycevMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import ZaycevMaven.ZaycevMavenProject.ZaycevBlocks.SearchBlock;
import org.openqa.selenium.WebDriver;
 
public class ZaycevSearchingPage extends BasePage{

	SearchBlock searchBlock;
    
    public ZaycevSearchingPage(WebDriver driver){
    	super(driver);
    }

	public void insertValueInPoiskFiels(String songValue) {
		try {
			searchBlock.allocateSerchInput();
			searchBlock.insertInSearchInput(songValue);
		} catch (Exception e){
			log.error("Song isn't inserted "+e);
		}
	}

	public void clickOnIskat() {
		try {
			searchBlock.clickFindButton();
			log.info("Iskat Button pressed");
		} catch (Exception e) {
			log.error("Error with Iskat Button "+e);
		}	
	}
	
	public String checkFirstSong(){
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.info("pervaja Pesna will be vzata");
			return searchBlock.getFirstSongGroup();
		} catch (Exception e) {
			log.error("Error with pervaja Pesna "+e);
			return null;
		}
	}
	
	public void clickPlayFirsSong() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			searchBlock.clickPlayFirsSongButton();
			log.info("Play First Song Button pressed");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("Error with Play First Button "+e);
		}	
	}

	/** РАБОЧИЙ ПРОСТО ЧТО БЫ НИЧЕГО НЕ СЛОМАТЬ
public void moveAndClickDownLoadButton() {
        
	    try {
	    	//actions.moveToElement(pervajaPesna).click().build().perform();
	    	actions.moveToElement(pervajaPesna);
			log.info("First Song highlighted");
			actions.moveToElement(downloadFirstSong).click().perform();
			log.info("DownLoad first Song button clicked");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 Set<String> handles = driver.getWindowHandles();
			 String firstWinHandle = driver.getWindowHandle(); 
			 handles.remove(firstWinHandle);
			 String winHandle = handles.iterator().next();
			 driver.switchTo().window(winHandle);
	    }
		 catch (Exception e) {
			
			log.error("Error with Download First Button "+e);
		}
	}
	*/
	
public AcdcPage moveAndClickDownLoadButton() {
        
	    try {
	    	searchBlock.moveToFirstSongButton();
			log.info("First Song highlighted");
			searchBlock.clickDownloadFirstSongButton();
			log.info("DownLoad first Song button clicked");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 Set<String> handles = driver.getWindowHandles();
			 String firstWinHandle = driver.getWindowHandle(); 
			 handles.remove(firstWinHandle);
			 String winHandle = handles.iterator().next();
			 driver.switchTo().window(winHandle);
	    }
		 catch (Exception e) {
			log.error("Error with Download First Button "+e);
		}
	    return new AcdcPage(driver);
	}	

	public boolean checkPlainingFirstSong(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		boolean isSongPlaying;
		try {
			isSongPlaying = searchBlock.checkPlayingFirstSongBar();
			if(isSongPlaying){
				log.info("First song is playinnig progress bar displayed");
			}
		} catch (Exception e) {
			log.error("First song is playinnig progress bar isn't displayed"+e);
			isSongPlaying = false;
		}
		return isSongPlaying;
	}
}
