package ZaycevMaven.ZaycevMavenProject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZaycevBadCredentialsPage {
	
	@FindBy(xpath="//div[@class='row row_registration authentication__field authentication_login clearfix login-social-place-page bad']//div[@class='field-error-msg']")
	WebElement invalidCredentionals;
	
	Logger log;
    WebDriver driver;
	

	public ZaycevBadCredentialsPage(WebDriver driver) {
		this.driver = driver;
		log = Logger.getLogger(getClass());
		PageFactory.initElements(driver, this);
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
}
