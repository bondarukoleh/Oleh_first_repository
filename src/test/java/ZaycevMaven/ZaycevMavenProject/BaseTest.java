package ZaycevMaven.ZaycevMavenProject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    WebDriver driver;
    ZaycevHomePage zaycevHomePage;
    ZaycevSearchingPage zaycevSearchingPage;
    ZaycevBadCredentialsPage zaycevBadCredentialsPage;
    AcdcPage acdcPage;

    @Before
    public void setUp() throws MalformedURLException {
        driver = getDriver("Chrome");
        zaycevHomePage = new ZaycevHomePage(driver);
        zaycevSearchingPage = new ZaycevSearchingPage(driver);
        acdcPage = new AcdcPage(driver);
    }

    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        zaycevHomePage.closeBrowser();
    }

    public WebDriver getDriver(String driverName){
        WebDriver driver = BrowserFactory.getBrowser(driverName);
        return driver;
    }
}
