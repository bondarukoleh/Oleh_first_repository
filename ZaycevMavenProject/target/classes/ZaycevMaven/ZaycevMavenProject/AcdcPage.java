package ZaycevMaven.ZaycevMavenProject;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcdcPage {

	WebDriver driver;
	Logger log;
	
	@FindBy(xpath =".//div[@id='audiotrack-page']//a[@class='musicset-track__link link-without-title']")
    WebElement checkSongName;
	
	@FindBy(xpath =".//*[@id='audiotrack-download-link']")
    WebElement downloadSongButton;
	
	public AcdcPage(WebDriver driver){
		this.driver = driver;
		log = Logger.getLogger(getClass());
		PageFactory.initElements(driver, this);
		}
	
	public String checkSongName(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			if (checkSongName.isDisplayed()) {
				log.info("Got song name what we want to download");
				return checkSongName.getText();
			}
			else{
				log.info("Song name isn't displayed");
				return null;
			}
		} catch (Exception e) {
			log.error("Couldn't find song name what we want to download "+e);
			return null;
		}
	}
	
	public boolean checkDownloadButtonEnable(){
		try {
			if (downloadSongButton.isEnabled()) {
				log.info("Download button checked (Enabled)");
				return true;
			}
			else{
				log.error("Download button isn't Enabled");
				return false;
			}
		} catch (Exception e) {
			log.error("Unable to reach download button "+e);
			return false;
		}
	}
}
