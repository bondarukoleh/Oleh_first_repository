package ZaycevMaven.ZaycevMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver;

        if (browserName == "Firefox") {
            driver = drivers.get("Firefox");
            if (driver == null) {
                System.setProperty("webdriver.gecko.driver", ".\\src\\libs\\geckodriver.exe");
                driver = new FirefoxDriver();
                drivers.put("Firefox", driver);
            }
        } else if (browserName == "IE") {
            driver = drivers.get("IE");
            if (driver == null) {
                System.setProperty("webdriver.ie.driver", ".\\src\\libs\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                drivers.put("IE", driver);
            }
        } else {
            driver = drivers.get("Chrome");
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", ".\\src\\libs\\chromedriver.exe");
                driver = new ChromeDriver();
                drivers.put("Chrome", driver);
            }
        }
        return driver;
    }
}


