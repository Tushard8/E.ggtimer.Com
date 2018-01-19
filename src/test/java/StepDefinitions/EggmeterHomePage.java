package StepDefinitions;

import PageObjects.CountdownPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class EggmeterHomePage extends BaseStepDef {

    public static final Logger LOGGER = LoggerFactory.getLogger(CountdownPage.class);

    @Before
    public void setUp(Scenario scenario) throws Exception {
        baseScenario = scenario;
        setDriver();
        initalize(localDriver);
    }

    @Given("^Eggmeter timer site is opened and page is loaded$")
    public void eggmeterTimerSiteIsOpenedAndPageIsLoaded() throws Throwable {
        basePage.openTestSite();
        Assert.assertTrue(homePage.isEggTimerHomePageLoaded());
    }

    @When("^User enter's time and click Go$")
    public void userEnterSTimeAndClickGo(DataTable table) throws Throwable {

        homePage.navigateToCountdownPage();

        List<timer> userentries = new ArrayList<timer>();
        userentries = table.asList(timer.class);

        for(timer timer:userentries)
        {
            System.out.println("User entered time:" + timer.time);
        }

    }

    @When("^User enter's ([^\"]*) and click Go$")
    public void userEnterSCountdowntimesAndClickGo(String countdowntimes) throws Throwable {
        System.out.print("Countdown timings are:" +countdowntimes);
        homePage.navigateToCountdownPage();
    }

    public class timer{
        public String time;

        public timer(String time) {
            this.time = time;
        }
    }


    @Then("^Countdown timer should start$")
    public void countdownTimerShouldStart() throws Throwable {

        Assert.assertTrue(homePage.isCountdownTimerPageLoaded());

    }

    @And("^Remaining time decreases in one-sec increments$")
    public void remainingTimeDecreasesInOneSecIncrements() throws Throwable {

        homePage.CountdownTimerWorking();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {
            terminateDriver();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}