package config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by babu on 09/07/2016.
 */
public class DriverSetup extends EventFiringWebDriver {

    public static String browser = "firefox";

    public static  WebDriver driver(){

        if (browser.equals("firefox")){

            DesiredCapabilities driver = DesiredCapabilities.firefox();
            driver.setPlatform(Platform.ANY);
            driver.setBrowserName(browser);
            return new FirefoxDriver();

        }else if (browser.equals("ie")){

        }else if (browser.equals("chrome")){

        }

        return driver();
    }

    public static final WebDriver REAL_DRIVER = driver();

    // driver initialisation logic
    public DriverSetup() {

        super(REAL_DRIVER);
        REAL_DRIVER.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        REAL_DRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        REAL_DRIVER.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        REAL_DRIVER.manage().deleteAllCookies();
        REAL_DRIVER.manage().window().maximize();
        // REAL_DRIVER.get(url);
    }


    // driver quit logic
    public static final Thread CLOSE_THREAD = new Thread() {

        @Override
        public void run() {
            REAL_DRIVER.quit();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

}

