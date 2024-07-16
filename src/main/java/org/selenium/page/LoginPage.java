package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.selenium.config.ConfigurationManager.configuration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='action login primary']")
    private WebElement signInButton;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void fillInLoginFields() {
        emailField.sendKeys(configuration().email());
        passwordField.sendKeys(configuration().password());
    }

    public void clickSingInButton() {
        signInButton.click();
    }
}
