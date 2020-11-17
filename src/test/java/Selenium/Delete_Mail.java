package Selenium;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Delete_Mail {


    @FindBy(xpath = "//div[.='Входящие'][1]")
    private WebElement buttonIN;

    @FindBy(xpath = "//span[@title=\"Удалить\"]")
    private WebElement deleteButton;

    public WebElement getDeleteButton() {
        return deleteButton;
    }


}

