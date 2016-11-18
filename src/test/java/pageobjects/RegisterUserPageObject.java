package pageobjects;


import org.apache.commons.lang3.RandomStringUtils;
import selectors.HomePageSelectors;
import selectors.RegisterPageSelectors;
import util.Util;

import java.util.List;

/**
 * Created by babu on 09/07/2016.
 */
public class RegisterUserPageObject extends Util {


    public static void registerNewUser(List<String> createUsersData) throws Exception {
         clickOnElement(HomePageSelectors.LINK_SIGNIN);
         sendKeys(RegisterPageSelectors.INPUT_REGISTER_EMAIL_ID, RandomStringUtils.randomAlphanumeric(5)+createUsersData.get(0));
         clickOnElement(RegisterPageSelectors.BUTTON_CREATE_ACCOUNT);
        if (createUsersData.get(1).equals("Mr")){
            clickOnElement(RegisterPageSelectors.BUTTON_MR);
        }else {
            clickOnElement(RegisterPageSelectors.BUTTON_MRS);
        }
        sendKeys(RegisterPageSelectors.INPUT_FIRST_NAME,createUsersData.get(2));
        selectElementByValue(RegisterPageSelectors.SELECT_DOB_DAY,createUsersData.get(3));
        sleepFor(5000);
    }

    public static void verifyUserRegistration(){


    }
}
