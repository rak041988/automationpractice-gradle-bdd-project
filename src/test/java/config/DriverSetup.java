package config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import static util.Util.getProperty;

/**
 * Created by babu on 09/07/2016.
 */
public class DriverSetup extends EventFiringWebDriver {

    public static String browser = getProperty("browser");



    public static  WebDriver driver(){

        if (browser.equals("firefox")) {
            System.out.println("************Tests are running on browser :"+getProperty("browser")+"*************");
            System.out.println("************Operating system is : "+System.getProperty("os.name")+"*************");
            if (System.getProperty("os.name").contains("Linux")){
                System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir") + "//tools//gecko/geckodriver");
            }else {
                System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir") + "//tools//gecko/geckodriver.exe");
            }
            //FirefoxDriverManager.getInstance().setup();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.ANY);
            capabilities.setBrowserName(browser);
            return new FirefoxDriver();
        } else if (browser.equals("ie")) {
            System.out.println("************Tests are running on browser :"+getProperty("browser")+"*************");
            System.out.println("************Operating system is : "+System.getProperty("os.name")+"*************");
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"//tools//IEDriver//InternetExplorerDriver.exe");
            return new InternetExplorerDriver();
            //need to add code for ie browser
        } else if (browser.equals("chrome")) {
            System.out.println("************Tests are running on browser :"+getProperty("browser")+"*************");
            System.out.println("************Operating system is : "+System.getProperty("os.name")+"*************");
            if (System.getProperty("os.name").contains("Linux")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("chrome.switches","--disable-extensions");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//tools//chrome//chromedriver");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName(browser);
                return new ChromeDriver(options);
            }else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("chrome.switches","--disable-extensions");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//tools//chrome//chromedriver.exe");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName(browser);
                return new ChromeDriver(options);
            }
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
