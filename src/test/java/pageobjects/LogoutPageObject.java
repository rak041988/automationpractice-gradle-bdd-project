package pageobjects;

import selectors.LogoutSelectors;
import util.Util;

/**
 * Created by babu on 12/07/2016.
 */
public class LogoutPageObject extends Util {

    public static void doUserLogOut()
    {
        clickOnElement(LogoutSelectors.LINK_SIGNOUT);
    }
}
