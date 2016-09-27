package ZaycevMaven.ZaycevMavenProject;

import java.util.concurrent.TimeUnit;
import ZaycevMaven.ZaycevMavenProject.ZaycevBlocks.FunctionBlock;
import ZaycevMaven.ZaycevMavenProject.ZaycevBlocks.ZaycevHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZaycevHomePage extends BasePage{

	ZaycevHeader zaycevHeader;
	FunctionBlock functionBlock;

	public ZaycevHomePage(WebDriver driver){
		super(driver);
	}

	public void openZaycevHomePage() {
		try {
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://zaycev.net/");
			wait.until(ExpectedConditions.titleContains("Зайцев.нет!"));
			log.info("Home page opened");
		} catch (Exception e) {
			log.error("Couldn't open home page" +e);
		}
	}

	public void closeBrowser() {
		try {
			driver.quit();
			log.info("Driver shuted down");
		} catch (Exception e) {
			log.error("Some trouble with shuting browser " +e);
		}
	}

	public void clickEnterButton() {
		try {
			zaycevHeader.clickLoginButton();
			log.info("Button Login clicked");
		} catch (Exception e) {
			log.error("Some trouble with Button Login " +e);
		}
		
	}

	public void enterEmail(String emailValue) {
		try {
			zaycevHeader.enterUserEmail(emailValue);
			log.info("Email entered");
		} catch (Exception e) {
			log.error("Some trouble with Email " +e);
		}
	}

	public void enterPassword(String passValue) {
		try {
			zaycevHeader.enterUserPassword(passValue);
			log.info("Password entered");
		} catch (Exception e) {
			log.error("Some trouble with Password " +e);
		}
	}

	public void clickEntryButton() {
		try {
			zaycevHeader.clickEnterButton();
			log.info("Entry button Enter clicked");
		} catch (Exception e) {
			log.error("Some trouble with Button Entry button " +e);
		}
	}

	public String checkThatUserEntered() {
		try {
			log.info("Got text from UserNam");
			return zaycevHeader.getLoggedUserName();
		} catch (Exception e) {
			log.error("Some trouble with getting text from UserNam " +e);
			return null;
		}
	}

   
	public ZaycevBadCredentialsPage checkBadCredentialsMessagefromBCpage() {
		try {
			log.info("Passed Text from Bad credentionals message");
			return new ZaycevBadCredentialsPage(driver);
		} catch (Exception e) {
			log.error("Some trouble with passing text from Bad credentionals message " +e);
			return null;
		}
	}
	
	public void clickOnPoiskLink(){
		try {
			functionBlock.clickSearchLink();
			log.info("Poisk link clicked");
		} catch (Exception e) {
			log.error("Some trouble with pPoisk link " +e);
		}
	}
}

