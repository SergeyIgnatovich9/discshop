package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = ".success")
    public WebElement successfullyAddedAddressMessage;

    @FindBy(xpath = "//a[contains (text(), 'Address Book')]")
    private WebElement addressbookLink;

    public AddressBook_Page clickAddressBookLink() {
        addressbookLink.click();
        return new AddressBook_Page();
    }
}