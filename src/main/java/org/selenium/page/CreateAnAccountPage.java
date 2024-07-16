package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.dto.UserAccount;

public class CreateAnAccountPage extends BasePage {

    @FindBy(css = ".primary .action span")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement createAccFirstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement createAccLastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement createAccEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement createAccPasswordField;

    @FindBy(css = ".confirmation .control input")
    private WebElement createAccConfirmPasswordField;

    public void fillInCreateAccountFields (UserAccount customer) {
        createAccFirstNameField.sendKeys(customer.getFirstName());
        createAccLastNameField.sendKeys(customer.getLastName());
        createAccEmailField.sendKeys(customer.getEmail());
        createAccPasswordField.sendKeys(customer.getPassword());
        createAccConfirmPasswordField.sendKeys(customer.getPassword());
    }

    public AccountPage createAccountButtonClick() {
        createAccountButton.click();
        return new AccountPage();
    }
}
