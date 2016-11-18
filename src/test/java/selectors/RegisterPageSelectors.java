package selectors;

import org.openqa.selenium.By;

/**
 * Created by babu on 10/07/2016.
 */
public class RegisterPageSelectors {

    public static final By INPUT_REGISTER_EMAIL_ID = By.cssSelector("#email_create");
    public static final By BUTTON_CREATE_ACCOUNT = By.cssSelector("#SubmitCreate");
    public static final By BUTTON_MR = By.cssSelector("#id_gender1");
    public static final By BUTTON_MRS = By.cssSelector("#id_gender2");
    public static final By INPUT_FIRST_NAME = By.cssSelector("#customer_firstname");
    public static final By SELECT_DOB_DAY = By.cssSelector("#days");
}
