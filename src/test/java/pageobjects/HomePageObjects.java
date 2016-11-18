package pageobjects;

import selectors.HomePageSelectors;
import util.Util;

/**
 * Created by babu on 09/07/2016.
 */
public class HomePageObjects extends Util{

    public static void userLogin(){
        clickOnElement(HomePageSelectors.LINK_SIGNIN);
        //username
        //password
        //click login
    }

}
