package PageObjects;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountdownPage extends BasePage {


    public CountdownPage(WebDriver driver) {
        super(driver);
        pageDriver = driver;

    }

    public WebDriver pageDriver;

    public static final Logger LOGGER = LoggerFactory.getLogger(CountdownPage.class);

    String verificationString = testData.readProperty("Countdown.Progress");


    public boolean isPageLoaded() {

        return seleniumLib.waitForElementVisible(seleniumLib.getElement(verificationString));
    }

}
