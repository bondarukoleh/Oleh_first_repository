package ZaycevMaven.ZaycevMavenProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class ZaycevSearchingPage {
	
	Logger log;
    WebDriver driver;
    Actions actions;
    
    @FindBy(xpath =".//*[@id='search-form-query']")
    WebElement fieldPoisk;
    
    @FindBy(xpath =".//*[@id='mailrusearchonpage']")
    WebElement checkboxMailRu;
    
    @FindBy(xpath =".//*[@id='search-form']//button")
    WebElement iskatButton;
    
    @FindBy(xpath ="//div[@class='musicset-track clearfix'][1]//div[@class='musicset-track__artist']/a")
    WebElement pervajaPesna;
    
    @FindBy(xpath =".//*[@class='musicset-track clearfix'][1]//i[@class='musicset-player__icon']")
    WebElement playFirstSong;
    
    @FindBy(xpath =".//*[@class='musicset-track clearfix'][1]//i[@class='musicset-icon musicset-icon_download']")
    WebElement downloadFirstSong;
    
    @FindBy(xpath =".//div[@class='musicset-progress__gap']")
    WebElement playingFirstSongProgress;
   
    
    public ZaycevSearchingPage(WebDriver driver){
    	this.driver = driver;
    	log = Logger.getLogger(getClass());
    	PageFactory.initElements(driver, this);
    	actions = new Actions(driver);
    }

	public void insertValueInPoiskFiels(String songValue) {
		try {
			fieldPoisk.click();
			fieldPoisk.sendKeys(songValue);
		} catch (Exception e) {
			log.error("Song isn't inserted "+e);
		}
	}

	public void unchekMailChekbox(){
		try{
		if (checkboxMailRu.isSelected()){
			checkboxMailRu.click();
			log.info("Checkboxu "+checkboxMailRu+" snyli vidilenie");
		}
		else {
			log.info("Checkbox "+checkboxMailRu+" i tak ne vibran, snimat' vidilenie ne nuzno");
   		}
		}
		catch (Exception e){
			log.error("Error s Checkboxom "+checkboxMailRu+", ne nashlo navernoe, vot takoy error "+e);
		}
	}

	public void clickOnIskat() {
		try {
			iskatButton.click();
			log.info("Iskat Button pressed");
		} catch (Exception e) {
			log.error("Error with Iskat Button "+e);
		}	
	}
	
	public String checkFirstSong(){
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.info("pervaja Pesna vzata");
			return pervajaPesna.getText();
		} catch (Exception e) {
			log.error("Error with pervaja Pesna "+e);
			return null;
		}
	}
	
	public void clickPlayFirsSong() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			playFirstSong.click();
			log.info("Play First Song Button pressed");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("Error with Play First Button "+e);
		}	
	}
	/**
	public void clickDownloadFirsSong() {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			downloadFirstSong.click();
			log.info("Download First Song Button pressed");
		} catch (Exception e) {
			log.error("Error with Download First Button "+e);
		}	
	}
    */
	
	/**
	public void clickDownloadFirsSongJS() {
        
	    try {
			String script = "var object = arguments[0];"
			        + "var theEvent = document.createEvent(\"MouseEvent\");"
			        + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
			        + "object.dispatchEvent(theEvent);"
			        ;
			((JavascriptExecutor)driver).executeScript(script, downloadFirstSong);
			log.info("Download First Song Button pressed");
		} catch (Exception e) {
			log.error("Error with Download First Button "+e);
		}
	}
	*/
	
	
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
	    return new AcdcPage(driver);
	}	

	public boolean checkPlainingFirstSong(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		boolean isSongPlaying;
		try {
			isSongPlaying = playingFirstSongProgress.isDisplayed();
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
