package Selenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Change_Signature {

    @FindBy(xpath = "//a[@data-test-id=\"page-card-signature\"]")
    private WebElement nameAndSign;

    @FindBy(xpath = "//button[@data-test-id=\"edit\"]")
    private WebElement buttonEdit;

    @FindBy(xpath = "//div[@data-test-id='editor']/div/div[contains(@class, 'editable-container')]/div[@contenteditable=\"true\"]")
    private WebElement signEditor;

    @FindBy(xpath = "//button[@data-test-id=\"save\" and @type=\"submit\"]")
    private WebElement buttonSave;

    @FindBy(xpath = "//button[@data-test-id=\"to-inbox\"]")
    private WebElement buttonToBox;

    @FindBy(xpath = "//div[contains(@class, 'editor_container')]")
    private WebElement editorMail;

    @FindBy(xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement buttonNewMail;

    @FindBy(xpath = "//div[@data-name=\"to\"]//input")
    private WebElement fieldTo;


    @FindBy(xpath = "//input[@name=\"Subject\"]")
    private WebElement fieldSubj;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement fieldBody;

    @FindBy(className = "button2__txt")
    private WebElement buttonSend;

    @FindBy(className = "c211")
    private WebElement exit;

    @FindBy(className = "nav__folder-name__txt")
    private WebElement buttonIN;

    @FindBy(xpath = "//span[@title=\"Вернуться\"]")
    private WebElement buttonBack;

    @FindBy(xpath = "//h2 [@class=\"thread__subject\"]")
    private WebElement subjInbox;

    @FindBy(xpath = "//div[@class=\"letter__body\"]")
    private WebElement bodyInbox;

    public WebElement getNameAndSign() {
        return nameAndSign;
    }

    public WebElement getButtonEdit() {
        return buttonEdit;
    }

    public WebElement getSignEditor() {
        return signEditor;
    }

    public WebElement getButtonSave() {
        return buttonSave;
    }

    public WebElement getButtonToBox() {
        return buttonToBox;
    }

    public WebElement getEditorMail() {
        return editorMail;
    }

    public WebElement getButtonBack() {
        return buttonBack;
    }

}
