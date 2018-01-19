package SeleniumWrapper;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SeleniumLib {
    WebDriver driver;
    WebDriverWait wait15sec;
    WebElement element;
    List<WebElement> elementList;

    private String timeoutErrorMessage(WebElement element) {
        return " Central Library :unable to find element" + element;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumLib.class);

    public SeleniumLib(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public boolean waitForElementVisible(WebElement element) {
        try {
            wait15sec = new WebDriverWait(driver, 15);
            wait15sec.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception t) {
            throw t;
        }
    }

    public void waitForTextPresentInElement(WebElement element, String str) {
        try {
            wait15sec = new WebDriverWait(driver, 15);
            wait15sec.until(ExpectedConditions.textToBePresentInElement(element, str));
        } catch (Exception t) {
            //log.log_library_error("Exception caught- Text not present after waiting 15 sec in Element"+ element + "" , t);
        }
    }
    public boolean isTextContainedInElement(WebElement element, String str) {
        try {
            return element.getText().contains(str);
        } catch (Exception t) {
            //log.log_library_error("Exception caught- Text not present in Element" + element + "", t);
            throw t;
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            waitForElementVisible(element);
            element.click();
            //log.log_library_track("Clicked on Element: " +element);
        } catch (Exception e) {
            //LOGGER.error("unable to click on element " + element);
            //log.log_library_error("unable to click on Element: "+ element , e);
            throw e;
        }
    }

    public void openURL(String URL) {
        try {
            driver.get(URL);
            //log.log_library_track("URL Clicked: " +URL);
        } catch (Exception e) {
            //log.log_library_error("unable to open URL : "+ URL , e);
            throw e;
        }
    }
    public void verifyPage(WebElement element) {
        try {
            waitForElementVisible(element);
            //log.log_library_track("Element Verification done on Page for Element: "+element);
        } catch (Exception e) {
            //log.log_library_error("unable to Verify Page as the element is not found "+ element , e);
            throw e;
        }
    }

    public void enterText(WebElement element, String str) {
        try {
            waitForElementVisible(element);
            element.sendKeys(str);
            //log.log_library_track("Text entered in the Element: "+element);
        } catch (Exception e) {
            //log.log_library_error("unable to enter text in the element as element is not found "+ element , e);
            throw e;
        }
    }

    public WebElement getElement(String str) {
        String strLocatorType = (str.split(":", 2)[0]).toLowerCase();
        String strLocatorValue = (str.split(":", 2)[1]);

        switch (strLocatorType) {

            case "id":
                element = driver.findElement(By.id(strLocatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(strLocatorValue));
                break;
            case "partiallink":
                element = driver.findElement(By.partialLinkText(strLocatorValue));
                break;
            case "linktext":
                element = driver.findElement(By.linkText(strLocatorValue));
                break;
            case "cssselector":
                element = driver.findElement(By.cssSelector(strLocatorValue));
                break;
            case "tagname":
                element = driver.findElement(By.tagName(strLocatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(strLocatorValue));
                break;
            default:
                //unable to open URL
                //log.log_library_error("unable to identify element using LocatorType \"" + strLocatorType+ "\" and Locator Value \"" +strLocatorValue+"\"");
                //LOGGER.error("unable to identify element using LocatorType " + strLocatorType+ "and Locator Value " +strLocatorValue);
                throw new NoSuchElementException("unknown locator Type");

        }
        return element;
    }


    public List<WebElement> getElementList(String str) {
        String strLocatorType = (str.split(":", 2)[0]).toLowerCase();
        String strLocatorValue = (str.split(":", 2)[1]).toLowerCase();

        switch (strLocatorType) {

            case "classname":
                elementList = driver.findElements(By.className(strLocatorValue));
                break;
            case "cssselector":
                elementList = driver.findElements(By.cssSelector(strLocatorValue));
                break;
            case "tagname":
                elementList = driver.findElements(By.tagName(strLocatorValue));
                break;
            default:


                //log.log_library_error("unable to identify element List using LocatorType = " + strLocatorType+ "and Locator Value =" + strLocatorValue);
                //    LOGGER.error("unable to identify element List using LocatorType " + strLocatorType+ "and Locator Valye " +strLocatorValue);
                throw new NoSuchElementException("unknown locator Type");


        }
        return elementList;
    }


    public void clickOnSpecifiedItemInList(List<WebElement> elementList, int x) {
        // may require correct level of exception management
        try {
            int size = elementList.size();
            //log.log_library_track("size of the list is "+ size);
            for (int i = 0; i < size && i == x; i++) {
                elementList.get(x).click();
            }

        } catch (Exception e) {
            //log.log_library_error("unable to click on element " + elementList +"value of x is "+x, e);
            //LOGGER.error("unable to click on element " + elementList +"value of x is " +x);
            throw e;
        }
    }

    public String getElementText(String str) {

        return getElement(str).getText();


    }
}
