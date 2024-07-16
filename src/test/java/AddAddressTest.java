import io.qameta.allure.TmsLink;
import io.qameta.allure.Description;
import org.selenium.helpers.PageUtil;
import org.selenium.page.*;
import org.selenium.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AddAddressTest extends BaseTest {

    @Description("Add new address to user's profile")
    @TmsLink("ID-003")
    @Test
    public void addAddressTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        AddNewAddressPage addNewAddressPage = homePage.clickAccountLink().
                clickAddressBookLink().clickAddNewAddressButton();
        addNewAddressPage.fillInAddressFields();
        AccountPage accountPage = addNewAddressPage.saveNewAddressButtonClick();
        Assert.assertTrue(PageUtil.isDisplayed(accountPage.successfullyAddedAddressMessage),
                "New address has not been added");
    }
}
