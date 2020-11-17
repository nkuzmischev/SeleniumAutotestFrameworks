package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Base extends General {
    WebDriver driver;
    private String ggrUrl = "https://e.mail.ru/inbox/";
    private String urlSign = "https://e.mail.ru/settings";
    private String adres = "testbox_2020@mail.ru";
    private String pass = "iR+iRaYiDu43";
    private String oldSignature = "My signature";
    private String newSignature = "My new signature";
    private String firstText = "First text";
    private String secondText = "Second text";
    private String subject = "subject";


    public Base(WebDriver driver) {
        super(driver);
    }

    @BeforeTest
    public void beforeT() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("h:/User/Downloads/chromedriver_win32/chromedriver.exe");

        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);


        URL hub = new URL(ggrUrl);
        driver = new RemoteWebDriver(hub, dc);
        driver.manage().window().maximize();

    }

    @Test
    public void TestsT() {
        Autorization auto = new Autorization();
        WebElement login = auto.getLoginField();
        WebElement password = auto.getPassField();
        WebElement buttonLogin = auto.getButtonPass();

        waitVisibilityOfElement(login);
        setText(login, adres);
        click(buttonLogin);
        waitVisibilityOfElement(password);
        setText(password, pass);
        click(buttonLogin);

        Sending_Mail send = new Sending_Mail();
        WebElement bodyInbox = send.getBodyInbox();
        WebElement buttonIN = send.getButtonIN();
        WebElement buttonNewMail = send.getButtonNewMail();
        WebElement buttonSend = send.getButtonSend();
        WebElement exit = send.getExit();
        WebElement fieldBody = send.getFieldBody();
        WebElement fieldSubj = send.getFieldSubj();
        WebElement fieldTo = send.getFieldTo();
        WebElement subjInbox = send.getSubjInbox();
        WebElement subj = send.getSubj();


        click(buttonNewMail);
        waitVisibilityOfElement(fieldTo);
        setText(fieldTo, adres);
        sleep(2000);
        click(fieldSubj);
        setText(fieldSubj, oldSignature);
        sleep(2000);
        setText(fieldBody, firstText);
        sleep(2000);
        click(buttonSend);
        sleep(2000);
        click(exit);

        click(buttonIN);
        sleep(10000);
        click(subj);
        sleep(10000);
        String subjIn = getText(subjInbox);
        String textIn = getText(bodyInbox);

        Change_Signature sign = new Change_Signature();
        WebElement nameAndSign = sign.getNameAndSign();
        WebElement buttonEdit = sign.getButtonEdit();
        WebElement signEditor = sign.getSignEditor();
        WebElement buttonSave = sign.getButtonSave();
        WebElement buttonToBox = sign.getButtonToBox();
        WebElement editorMail = sign.getEditorMail();
        WebElement buttonBack = sign.getButtonBack();


        sleep(3000);
        getDriver().get(urlSign);
        click(nameAndSign);
        sleep(3000);
        click(buttonEdit);
        sleep(3000);
        click(signEditor);
        setText(signEditor, newSignature);
        click(buttonSave);
        sleep(2000);
        click(buttonToBox);
        sleep(2000);
        click(buttonNewMail);
        sleep(3000);
        String editorText = getText(editorMail);

        Assert.assertEquals(editorText, newSignature);

        setText(fieldTo, adres);
        click(fieldTo);
        sleep(3000);
        setText(fieldSubj, subject);
        setText(fieldBody, "999");
        click(buttonSend);
        sleep(3000);
        click(exit);
        sleep(1000);
        click(buttonIN);
        sleep(3000);
        getDriver().findElement(By.xpath("//span[contains (.,\"" + subj + "\")][1]")).click();
        sleep(3000);

        Assert.assertEquals(getText(subjInbox), subject);
        Assert.assertEquals(getText(bodyInbox), newSignature);

        click(buttonBack);
        sleep(3000);

        Delete_Mail del = new Delete_Mail();
        WebElement deleteButton = del.getDeleteButton();

        click(buttonIN);
        sleep(3000);
        WebElement mesaage1 = getDriver().findElement(By.xpath("//a[contains(.,'" + subject + "')]//button[1]"));

        mesaage1.click();

        click(deleteButton);
        Boolean check1 = waitNotVisibilityOfElement(mesaage1);


    }

    @AfterTest
    public void afterT() {
        driver.quit();
        if (driver != null) {
            driver.quit();
        }

    }


}
