package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.page.section.Header;

public class HomePage extends BasePage {

    @FindBy(css = ".authorization-link a")
    private WebElement signInLink;

    @FindBy(css = ".header li:nth-child(3) a")
    private WebElement createAccountLink;

    @FindBy(css = ".logged-in")
    public WebElement welcomeMessage;

    @FindBy(css = ".customer-name .action")
    public WebElement dropDownMenu;

    @FindBy(css = ".customer-menu li:nth-child(1)")
    public WebElement getDropDownMyAccOption;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public Header getHeader() {
        return new Header();
    }

    public LoginPage clickSignInLink() {
        signInLink.click();
        return new LoginPage();
    }

    public AccountPage clickAccountLink() {
        dropDownMenu.click();
        getDropDownMyAccOption.click();
        return new AccountPage();
    }

    public CreateAnAccountPage clickCreateAccountLink() {
        createAccountLink.click();
        return new CreateAnAccountPage();
    }
}
