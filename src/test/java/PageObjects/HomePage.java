package PageObjects;

import StepDefinitions.EggmeterHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jsoup.nodes.Entities.EscapeMode.base;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        pageDriver = driver;

    }

    public WebDriver pageDriver;

    String StartTimer = pageElements.readProperty("HomePage.StartTimer");
    String GoTimer = pageElements.readProperty("HomePage.GoTimer");
    String TimerProgress = pageElements.readProperty("Countdown.Progress");

    public boolean isEggTimerHomePageLoaded() {

        return seleniumLib.waitForElementVisible(seleniumLib.getElement(StartTimer));

    }

    public void navigateToCountdownPage() {

        seleniumLib.getElement(StartTimer).clear();
        seleniumLib.getElement(StartTimer).sendKeys("25 seconds");
        seleniumLib.clickOnElement(seleniumLib.getElement(GoTimer));
    }
    public boolean isCountdownTimerPageLoaded(){

        return seleniumLib.waitForElementVisible(seleniumLib.getElement(TimerProgress));

    }

    public void CountdownTimerWorking(){

        WebElement ProgressText = seleniumLib.getElement(TimerProgress);
        System.out.println("ProgressText is : "+ ProgressText.getAttribute(TimerProgress));
    }
}