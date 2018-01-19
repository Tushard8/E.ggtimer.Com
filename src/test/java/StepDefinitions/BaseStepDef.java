package StepDefinitions;

import PageObjects.BasePage;
import PageObjects.CountdownPage;
import PageObjects.HomePage;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseStepDef {
    //public static WebDriver remoteDriver;
    Scenario baseScenario;
    public static WebDriver localDriver;

    protected static BasePage basePage;
    protected static HomePage homePage;
    protected static CountdownPage countdownPage;


    public void setDriver() throws Exception {
        //log.log_def_track("Start setDriver of BaseSteps");

        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver\\geckodriver.exe");
        localDriver = new FirefoxDriver();
        localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void terminateDriver() throws Exception {
        localDriver.quit();
        localDriver = null;
    }

    public void initalize(WebDriver driver) {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        countdownPage = new CountdownPage(driver);
    }

}