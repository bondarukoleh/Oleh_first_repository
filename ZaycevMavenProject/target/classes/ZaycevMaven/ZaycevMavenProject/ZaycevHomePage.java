package ZaycevMaven.ZaycevMavenProject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZaycevHomePage {
	
	WebDriver driver;
	Logger log;
	
	@FindBy(xpath =".//*[@id='page-head']//a[2]")
	WebElement knopkaHomeVhod;
	
	@FindBy(xpath =".//*[@id='j_username_']")
	WebElement loginHome;
	
	@FindBy(xpath =".//*[@id='j_password_']")
	WebElement passwordHome;
	
	@FindBy(xpath =".//*[@id='page-head']//form/div[4]/button")
	WebElement knopkaVoitiHome;
	
	@FindBy(xpath =".//*[@class='person-profile-info__open-menu']")
	WebElement UserName;
	
	@FindBy(xpath =".//*[@id='zina-region-leftmenutop']//li[2]/a")
	WebElement linkPoisk;
	
	@FindBy(xpath="//div[@class='row row_registration authentication__field authentication_login clearfix login-social-place-page bad']//div[@class='field-error-msg']")
	WebElement invalidCredentionals;

	public ZaycevHomePage(WebDriver driver) {
		this.driver = driver;
		log = Logger.getLogger(getClass());
		PageFactory.initElements(driver, this);
	}

	public void openZaycevHomePage() {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://zaycev.net/");
			log.info("Home page opened");;
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
			knopkaHomeVhod.click();
			log.info("Button Enter clicked");
		} catch (Exception e) {
			log.error("Some trouble with Button Enter " +e);
		}
		
	}

	public void enterEmail(String emailValue) {
		try {
			loginHome.sendKeys(emailValue);
			log.info("Email entered");
		} catch (Exception e) {
			log.error("Some trouble with Email " +e);
		}
	}

	public void enterPassword(String passValue) {
		try {
			passwordHome.sendKeys(passValue);
			log.info("Password entered");
		} catch (Exception e) {
			log.error("Some trouble with Password " +e);
		}
	}

	public void clickEntryButton() {
		try {
			knopkaVoitiHome.click();
			log.info("Entry button Enter clicked");
		} catch (Exception e) {
			log.error("Some trouble with Button Entry button " +e);
		}
	}

	public String checkThatUserEntered() {
		try {
			log.info("Got text from UserNam");
			return UserName.getText();
		} catch (Exception e) {
			log.error("Some trouble with getting text from UserNam " +e);
			return null;
		}
	}
	
	public String checkBadCredentialsMessage() {
		try {
			invalidCredentionals.isDisplayed();
			log.info("Message about bad credentionals is displayed");
			log.info("Got message about bad credentionals");
			return invalidCredentionals.getText();
		} catch (Exception e) {
			log.error("Some troubles with Bad Credantionals message "+e);
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
			linkPoisk.click();
			log.info("Poisk link clicked");
		} catch (Exception e) {
			log.error("Some trouble with pPoisk link " +e);
		}
	}
}

