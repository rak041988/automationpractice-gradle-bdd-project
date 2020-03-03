package stepdefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by babu on 09/07/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        format = {"pretty", "html: cucumber-html-reports", "json: cucumber-html-reports/cucumber.json"},
        tags = "@test"
       )
public class RunCukesTest {
}
