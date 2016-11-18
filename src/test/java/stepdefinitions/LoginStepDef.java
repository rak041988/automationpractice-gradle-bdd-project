package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LoginPageObject;
import selectors.LogoutSelectors;
import selectors.MyAccountPageSelectors;
import util.Util;

import java.util.List;

/**
 * Created by babu on 12/07/2016.
 */
public class LoginStepDef {


    @When("^I login with user data \"([^\"]*)\"$")
    public void iLoginWithUserData(List<String> userLogins) throws Exception {
        LoginPageObject.doUserLogin(userLogins);
    }

    @Then("^I verify my account page$")
    public void iVerifyMyAccountPage() throws Throwable {
        Util.verifyElementPresent(LogoutSelectors.LINK_SIGNOUT);
        Util.verifyDisplayedText(MyAccountPageSelectors.TEXT_MY_ACCOUNT,"MY ACCOUNT");

    }
}
