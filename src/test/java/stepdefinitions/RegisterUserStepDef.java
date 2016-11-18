package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.RegisterUserPageObject;
import util.Util;

import java.util.List;

/**
 * Created by babu on 09/07/2016.
 */
public class RegisterUserStepDef {

    @Given("^I navigate to automationpractise$")
    public void I_navigate_to_automationpractise() throws Exception {
        Util.openUrl();
    }

    @Then("^I verify the user registered success$")
    public void I_verify_the_user_registered_success() throws Exception {
         RegisterUserPageObject.verifyUserRegistration();
    }

    @When("^I register a user with data \"([^\"]*)\"$")
    public void iRegisterAUserWithData(List<String> newUserRegisterDetails) throws Exception {
        RegisterUserPageObject.registerNewUser(newUserRegisterDetails );
    }
}
