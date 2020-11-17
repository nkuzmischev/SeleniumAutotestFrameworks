package Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sending_Mail {


    @FindBy(xpath = "//a[@title=\"Написать письмо\"]")
    private WebElement buttonNewMail;


    @FindBy(xpath = "//div[@data-name=\"to\"]//input")
    private WebElement fieldTo;


    @FindBy(xpath = "//input[@name=\"Subject\"]")
    private WebElement fieldSubj;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement fieldBody;

    @FindBy(xpath = "//span[@title=\"Отправить\"]")
    private WebElement buttonSend;

    @FindBy(xpath = "//a[.='Письмо отправлено']")
    private WebElement titleSend;

    @FindBy(xpath = "//div[.='Входящие'][1]")
    private WebElement buttonIN;

    @FindBy(xpath = "//span[@title=\"Закрыть\"]")
    private WebElement exit;

    @FindBy(xpath = "//h2 [@class=\"thread__subject\"]")
    private WebElement subjInbox;

    @FindBy(xpath = "//span[class=\"ll-sj__normal\"]")
    private WebElement subj;

    @FindBy(xpath = "//div[@class=\"letter__body\"]")
    private WebElement bodyInbox;
    private WebElement NameAndSign;

    public WebElement getBodyInbox() {
        return bodyInbox;
    }

    public WebElement getButtonIN() {
        return buttonIN;
    }

    public WebElement getButtonNewMail() {
        return buttonNewMail;
    }

    public WebElement getButtonSend() {
        return buttonSend;
    }

    public WebElement getExit() {
        return exit;
    }

    public WebElement getFieldBody() {
        return fieldBody;
    }

    public WebElement getFieldSubj() {
        return fieldSubj;
    }

    public WebElement getFieldTo() {
        return fieldTo;
    }

    public WebElement getSubjInbox() {
        return subjInbox;
    }

    public WebElement getSubj() {
        return subj;
    }

}
