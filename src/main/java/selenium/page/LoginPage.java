package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='send2'][@class='action login primary']")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@id='email-error']")
    private WebElement errorMessageEmail;
    @FindBy(xpath = "//*[@id='pass-error']")
    private WebElement errorMessagePassword;
    @FindBy(xpath = "//*[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement errorMessageWrongCreds;
    @FindBy(xpath = "//span[contains (text(), 'Forgot Your Password?')]")
    private WebElement forgotPasswordLink;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void fillInEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage clickSingInButton() {
        signInButton.click();
        return new HomePage();
    }

    public String getErrorMessageWrongCredsText() {
        return errorMessageWrongCreds.getText();
    }

    public ForgotYourPasswordPage clickForgotYourPasswordLink() {
        forgotPasswordLink.click();
        return new ForgotYourPasswordPage();
    }

    public String getEmailErrorMessageText() {
        return errorMessageEmail.getText();
    }

    public String getPasswordErrorMessageText() {
        return errorMessagePassword.getText();
    }
}
