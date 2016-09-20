package ZaycevMaven.ZaycevMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    public WebDriver getFFdriver(){
        System.setProperty("webdriver.gecko.driver", ".\\src\\libs\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public Page getCurrentPageaa
}
