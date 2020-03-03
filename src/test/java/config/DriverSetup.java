package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import static util.Util.ReadPropertiesFile;
import static util.Util.getProperty;

/**
 * Created by babu on 09/07/2016.
 */
public class DriverSetup {


    public String browser;
    public static WebDriver driver;

    public DriverSetup() {
        browser = ReadPropertiesFile("browser");
        if (browser.isEmpty() || browser == null) {
            throw new RuntimeException("Please set browser key in config.properties....");
        }
    }

    public WebDriver openBrowswer() {
        if (browser.equalsIgnoreCase("firfox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void closeBrowser() {
        driver.quit();
    }
}


