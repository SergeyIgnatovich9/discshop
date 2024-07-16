package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.dto.Address;
import org.selenium.helpers.TestUtil;
import static org.selenium.helpers.Const.WARSAW_ADDRESS;

public class AddNewAddressPage extends BasePage {
    @FindBy(xpath = "//*[@id='telephone']")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='street_1']")
    private WebElement streetAddressField;

    @FindBy(xpath = "//*[@id='city']")
    private WebElement city;

    @FindBy(xpath ="//*[@id='region_id']")
    private WebElement state;

    @FindBy(xpath = "//*[@id='zip']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//*[@data-action='save-address']")
    private WebElement saveNewAddressButton;

    public void fillInAddressFields() {
        Address addresses = TestUtil.getAddresses(WARSAW_ADDRESS);
        phoneField.sendKeys(addresses.getPhoneNumber());
        streetAddressField.sendKeys(addresses.getStreet());
        city.sendKeys(addresses.getCity());
        country.sendKeys(addresses.getCountry());
        state.sendKeys(addresses.getState());
        postalCode.sendKeys(addresses.getPostalCode());
    }

    public AccountPage saveNewAddressButtonClick() {
        saveNewAddressButton.click();
        return new AccountPage();
    }
}

