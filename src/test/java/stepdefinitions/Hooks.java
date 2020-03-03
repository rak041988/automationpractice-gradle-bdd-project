package stepdefinitions;

import config.DriverSetup;
import cucumber.api.java.Before;

public class Hooks {

    DriverSetup driverSetup= new DriverSetup();

    @Before
    public void setUp(){
        driverSetup.openBrowswer();
    }

    public void tearDown(){
        driverSetup.closeBrowser();
    }
}
