package ZaycevMaven.ZaycevMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import ZaycevMaven.ZaycevMavenProject.zaycevBlocks.SearchBlock;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;


public class ZaycevSearchingPage extends BasePage{

	SearchBlock searchBlock;
	@Name("Dowload first song button")
	@FindBy(xpath =".//*[@class='musicset-track clearfix'][1]//i[@class='musicset-icon musicset-icon_download']")
	protected Button downloadFirstSongA;

    
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


public AcdcPage moveAndClickDownLoadButton1() {

	    try {
	    	//actions.moveToElement(pervajaPesna).click().build().perform();
	    	//actions.moveToElement(downloadFirstSongA);
			searchBlock.clickPlayFirsSongButton();
			log.info("First Song highlighted");
			//actions.moveToElement(downloadFirstSongA).click().build().perform();
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

	/**-------------------------------ПОЛНЫЙ ОТСТОЙ А НЕ МЕТОД :(((((((((----------------------------*/
public AcdcPage moveAndClickDownLoadButton() {
        
	    try {
			searchBlock.clickPlayFirsSongButton();
			//searchBlock.hoverOnFirstSong();
			log.info("First Song highlighted");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//actions.moveToElement(downloadFirstSongA).click();
			String script = "var object = arguments[0];"
					+ "var theEvent = document.createEvent(\"MouseEvent\");"
					+ "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "object.dispatchEvent(theEvent);"
					;
			((JavascriptExecutor)driver).executeScript(script, downloadFirstSongA);
			log.info("DownLoad first Song button clicked");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 Set<String> handles = driver.getWindowHandles();
			 //String firstWinHandle = driver.getWindowHandle();
			 //handles.remove(firstWinHandle);
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
