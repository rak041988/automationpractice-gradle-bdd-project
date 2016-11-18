package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageobjects.LogoutPageObject;
import selectors.HomePageSelectors;
import util.Util;

/**
 * Created by babu on 12/07/2016.
 */
public class LogoutStepDef {

    @Then("^I should logout$")
    public void iShouldLogout() throws Exception {
        LogoutPageObject.doUserLogOut();
    }

    @And("^I verify home page$")
    public void iVerifyLogoutPage() throws Exception {

        Util.verifyElementPresent(HomePageSelectors.LINK_SIGNIN);
        Util.verifyElementPresent(HomePageSelectors.INPUT_EMAIL_LOGIN);
        Util.verifyElementPresent(HomePageSelectors.INPUT_PASSWORD_LOGIN);
        Util.verifyElementPresent(HomePageSelectors.BUTTON_LOGIN);


    }
}
