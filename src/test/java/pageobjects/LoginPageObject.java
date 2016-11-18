package pageobjects;

import selectors.HomePageSelectors;
import util.Util;

import java.util.List;

/**
 * Created by babu on 12/07/2016.
 */
public class LoginPageObject extends Util {

    public static void doUserLogin(List <String> userLogins){

        clickOnElement(HomePageSelectors.LINK_SIGNIN);
        sendKeys(HomePageSelectors.INPUT_EMAIL_LOGIN,userLogins.get(0));
        sendKeys(HomePageSelectors.INPUT_PASSWORD_LOGIN,userLogins.get(1));
        clickOnElement(HomePageSelectors.BUTTON_LOGIN);
    }
}
