package ZaycevMaven.ZaycevMavenProject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    WebDriver driver;
    ZaycevHomePage zaycevHomePage;
    ZaycevSearchingPage zaycevSearchingPage;
    ZaycevBadCredentialsPage zaycevBadCredentialsPage;
    AcdcPage acdcPage;

    @Before
    public void setUp(){
        driver = getDriver("Chrome");
        zaycevHomePage = new ZaycevHomePage(driver);
        zaycevSearchingPage = new ZaycevSearchingPage(driver);
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
