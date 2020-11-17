package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General {
    private WebDriver driver;

    protected final int driverWaitTime = 20;

    public General(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    protected Boolean waitVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    protected Boolean waitNotVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    protected void click(final WebElement webElement) {

        waitVisibilityOfElement(webElement);

        webElement.click();

    }


    protected void setText(final WebElement webElement, final String string) {
        waitVisibilityOfElement(webElement);

        webElement.sendKeys(string);

    }

    protected String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected void sleep(int mls) {
        try {
            Thread.sleep(mls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected Boolean waitPresentOfElement(final String xpath) {

        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    protected void click(final String xpath) {
        waitPresentOfElement(xpath);
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        waitVisibilityOfElement(webElement);
        webElement.click();

    }
}
