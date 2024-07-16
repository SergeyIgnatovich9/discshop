package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBook_Page extends BasePage {

    @FindBy(css = ".actions-toolbar .action")
    public WebElement addNewAddressButton;

    public AddNewAddressPage clickAddNewAddressButton() {
        addNewAddressButton.click();
        return new AddNewAddressPage();
    }
}