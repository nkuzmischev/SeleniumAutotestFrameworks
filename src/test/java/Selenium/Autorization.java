package Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Autorization {
    @FindBy(className = ("o-control"))
    private WebElement loginField;


    @FindBy(id = "mailbox:password-input")
    private WebElement passField;

    @FindBy(className = "mailbox__icon mailbox__icon_next")
    private WebElement buttonPass;


    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPassField() {
        return passField;
    }

    public WebElement getButtonPass() {
        return buttonPass;
    }
}
