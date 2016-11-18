package selectors;

import org.openqa.selenium.By;

/**
 * Created by babu on 12/07/2016.
 */
public class AddItemsSelectors {
    public static final By WOMEN_LINK = By.cssSelector("a[title=\"Women\"]");
    public static final By FADED_HOOVER = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img");
   // public static final By FADED_SHIRT = By.cssSelector("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span");
   public static final By BUTTON_ADD_TO_CART    = By.cssSelector("button[class=\"exclusive\"]");
    public static final By BUTTON_PROCEED_CHECKOUT = By.cssSelector("a[title=\"Proceed to checkout\"]");
}
