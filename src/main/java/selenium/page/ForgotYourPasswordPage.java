package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPasswordPage extends BasePage {

    @FindBy(xpath = "//span[contains (text(), 'Reset My Password')]")
    private WebElement resetPasswordButton;

    public ForgotYourPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean forgotYourPasswordButtonIsDisplayed() {
        return resetPasswordButton.isDisplayed();
    }
}
