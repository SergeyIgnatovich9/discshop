package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends BasePage {

    @FindBy(xpath = "//span[contains (text(), 'Create New Customer Account')]")
    private WebElement createAccountTitle;

    public CreateAnAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean createAnAccountPageIsDisplayed() {
        return createAccountTitle.isDisplayed();
    }
}
