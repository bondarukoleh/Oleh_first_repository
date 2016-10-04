package ZaycevMaven.ZaycevMavenProject;

import java.util.concurrent.TimeUnit;
import ZaycevMaven.ZaycevMavenProject.zaycevBlocks.SingeSongBlock;
import org.openqa.selenium.WebDriver;

public class AcdcPage extends BasePage{

	SingeSongBlock singeSongBlock;
	
	public AcdcPage(WebDriver driver){
		super(driver);
		}
	
	public String checkSongName(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
				log.info("will get song group name which we want to download");
				return singeSongBlock.getSongGroupName();
		} catch (Exception e) {
			log.error("Couldn't find song name what we want to download "+e);
			return null;
		}
	}
	
	public boolean checkDownloadButtonEnable(){
		try {
			if (singeSongBlock.downloadSongButtonIsEnabled()) {
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

	public void clickOnPoisk(){
		singeSongBlock.clickSearchAAA();
	}
}

