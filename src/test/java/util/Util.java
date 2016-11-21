package util;

import config.DriverSetup;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by babu on 09/07/2016.
 */
public class Util {

    static DriverSetup driver = new DriverSetup();
    public static String url = getProperty("url");
    public static String configFile = CurrentDirectory() + "/config.properties";
    public static String configProperty;

    /**
     * Displays the Log Information
     *
     * @param LogString
     * @return Log
     * @throws Exception
     */
    public static Logger Log(String LogString) throws Exception {
        PropertyConfigurator.configure("log4j.properties");
        final Logger Log = Logger.getLogger("Log:");
        Log.info(LogString);
        return Log;
    }

    /**
     * Gets the property file     *
     * @param Property
     * @return configProperty
     */
    public static String getProperty(String Property) {
        if (System.getProperty(Property) == null ) {
            configProperty = ReadPropertiesFile(Property);
        } else {
            configProperty = SetPropertiesFile(getConfigFile(), Property, System.getProperty(Property).toLowerCase());
        }
        return configProperty;
    }

    /**
     * gets the current directory
     *
     * @return CurDir
     */
    public static String CurrentDirectory() {
        String CurDir = System.getProperty("user.dir");
        return CurDir;
    }

    public static String getConfigFile() {
        return configFile;
    }

    /**
     * Read's properties file
     *
     * @param
     * @param key
     * @return getProperty
     */
    public static String ReadPropertiesFile(String key) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(CurrentDirectory() + "/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    /**
     * Sets the properties File
     *
     * @param fileName
     * @param key
     * @param value
     * @return getProperty
     */
    public static String SetPropertiesFile(String fileName, String key, String value) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        prop.setProperty(key, value);
        return prop.getProperty(key);
    }















































    /**
     * To open the URL of the App
     *
     * @throws IOException
     */
    public static void openUrl() throws IOException {
        driver.get(url);

    }

    /**
     * Method to click on an Element
     *
     * @param locator
     */
    public static void clickOnElement(By locator) {

        driver.findElement(locator).click();
    }

    /**
     * Method to Send Keys
     *
     * @param locator
     * @param text
     */
    public static void sendKeys(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public static void selectElement(By locator, String option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(option);
    }


    /**
     * @param locator
     * @return
     */
    public static Boolean isElementEnabled(By locator) {
        return Boolean.valueOf(driver.findElement(locator).isEnabled());
    }

    /**
     * Method to refresh the current Page
     */
    public  void refreshPage() {
        Actions actionObject = new Actions(driver);
        actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public  void selectElementByText(By locator, String option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(option);
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public static void selectElementByValue(By locator, String option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(option);
    }

    /**
     * Select an element from drop list
     *
     * @param locator
     * @param option
     */
    public static void selectElementByIndex(By locator, int option) throws Exception {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(option);
    }
    /**
     * Method to verify a message displayed on web page
     *
     * @param locator
     * @param message
     */
    public static void verifyDisplayedText(By locator, String message) {
        String actualResult = driver.findElement(locator).getText();
        try {
            assertEquals(message, actualResult);
//				System.out.println(actualResult);
        } catch (Exception e) {
            System.out.println("Cannot find the Mesaage");
        }
    }

    /**
     * Get inner text from an Element from Attribute
     *
     * @param locator
     * @return
     */
    public String getDisplayedText(By locator) {

        return driver.findElement(locator).getAttribute("innerText");
    }

    /**
     * Method to get the Text
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {

        return driver.findElement(locator).getText();
    }

    /**
     * getCss
     *
     * @return WebElement
     * @throws InterruptedException
     * @paramCss
     */
    public WebElement getCss(By locator) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver.findElement(locator);
    }

    /**
     * Method to verify entered text
     *
     * @param locator
     * @param message
     */
    public void verifyTextPresent(By locator, String message) {
        String actualResult = driver.findElement(locator).getAttribute("value");
        try {
            assertEquals(message, actualResult);
        } catch (Exception e) {
            System.out.println("Text is not present");
        }
    }

    /**
     * Method to verify element is displayed
     *
     * @param locator
     *
     */
    public static void verifyElementPresent(By locator) {
        try {
            assertTrue(driver.findElement(locator).isDisplayed());

        } catch (Exception e) {
            System.out.println("Element is not present");
        }
    }

    /**
     * Method to check Element  is selected
     *
     * @param locator
     * @return
     */
    public Boolean isElementSelected(By locator) {

        return (driver.findElement(locator).isSelected());
    }

    /**
     * Method to check Element  is Displayed
     *
     * @param locator
     * @return
     */
    public Boolean checkIfDisplayed(By locator) {

        return driver.findElement(locator).isDisplayed();
    }

    /**
     * Method to mouseOver
     *
     * @param locator
     */
    public  void mouseOver(By locator) {
        driver.findElement(locator);
        WebElement hoverObject = driver.findElement(locator);

        Actions builder = new Actions(driver);
        builder.moveToElement(hoverObject).build().perform();

    }

    /**
     * Mouse over and Click
     *
     * @param idSelector
     * @param clickidSelector
     * @throws Exception
     */
    public void mouseOverAndClick(By idSelector, By clickidSelector) throws Exception {
        WebElement item, itemOption;
        //get the element that shows menu with the mouseOver event
        item = driver.findElement(idSelector);
        item.click();
        Thread.sleep(8000);
        //the element that I want to click (hidden)
        itemOption = driver.findElement(clickidSelector);
        itemOption.click();
    }

    /**
     * MouseOver
     *
     * @param idSelector
     */
    public   void mouseOver(String idSelector) {
        //get the element that shows menu with the mouseOver event
        WebElement item = driver.findElement(By.cssSelector(idSelector));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(driver);
        builder.moveToElement(item).build().perform();
    }

    /**
     * getCss
     *
     * @return WebElement
     * @throws InterruptedException
     * @paramCss
     */
    public WebElement getCss(String Csskey) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.cssSelector(Csskey));
    }


    /**
     * Returns the element when visible
     * Focus to
     * @param Css
     * @return
     */
   /* public WebElement waitForVisible(String css) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        return element;
    }*/

    /**
     * Returns the element when visible
     * Focus to
     *
     * @param locator
     * @return
     */
    public WebElement waitForVisible(By locator) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 90);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }


    public boolean checkIfDecimal(String amount){
        return amount.matches("[0-9.]*");
    }


    /**
     * Verify Text Present
     *
     * @param idSelector
     * @param textToBeFound
     * @return
     * @throws Exception
     */
    public boolean verifyTextPresent(String idSelector, String textToBeFound) throws Exception {
        List<WebElement> listWebElements = driver.findElements(By.cssSelector(idSelector));
        boolean found = false;

        for (WebElement webElement : listWebElements) {
            if (webElement.getText().contains(textToBeFound)) {
                found = true;
            }
        }

        return found;
    }

    /**
     * Drag and Drop
     *
     * @param startpoint
     * @param endpoint
     * @throws InterruptedException
     */
    public void dragAndDrop(String startpoint, String endpoint) throws InterruptedException {
        WebElement startPoint = getCss(startpoint);
        WebElement endPoint = getCss(endpoint);

        Actions actionMan = new Actions(driver);
        actionMan.clickAndHold(startPoint).moveToElement(endPoint).perform();

        Thread.sleep(1000);
        actionMan.release().perform();
    }

    /**
     * double Click
     * @param elementToClick
     */
    public void doubleClickonElement(By elementToClick){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(elementToClick)).doubleClick().build().perform();
    }

    /**
     * switch to iframe
     * @param locator
     */
    public void switchToIframe(By locator) {
        WebElement webelement = getCss(locator);
        driver.switchTo().frame(webelement);
    }
    /**
     * swithc to default content from iFrame
     */
    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
    /**
     * Waits for alert to appear
     * @throws Exception
     */
    public void waitForAlert() throws Exception {
        {
            int i=0;
            while(i++<6)
            {
                try
                {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    break;
                }
                catch(NoAlertPresentException e)
                {
                    sleepFor(2000);
                    continue;
                }
            }
        }
    }
    public void waitAndDismissAlert() throws Exception {
        {
            int i=0;
            while(i++<30)
            {
                try
                {
                    Alert alert = driver.switchTo().alert();
                    alert.dismiss();
                    break;
                }
                catch(NoAlertPresentException e)
                {
                    sleepFor(2000);
                    continue;
                }
            }
        }
    }
    /**
     * sleeps for a time set
     * @param timer
     */
    public static void sleepFor(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep exception occurred...", e);
        }
    }

}



