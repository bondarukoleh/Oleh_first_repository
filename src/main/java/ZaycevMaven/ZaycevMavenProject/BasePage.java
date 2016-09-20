package ZaycevMaven.ZaycevMavenProject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Bond on 9/20/2016.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }
}
