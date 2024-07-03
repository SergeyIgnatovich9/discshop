package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li/a[contains(text(), 'Sign In')]")
    private WebElement signInLink;
    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//a[contains (text(), 'Create an Account')]")
    private WebElement createAnAccountLink;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignInLink() {
        signInLink.click();
        return new LoginPage();
    }

    public CreateAnAccountPage clickCreateAnAccountLink() {
        createAnAccountLink.click();
        return new CreateAnAccountPage();
    }

    public boolean welcomMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }
}
