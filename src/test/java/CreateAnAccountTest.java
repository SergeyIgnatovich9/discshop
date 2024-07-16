import io.qameta.allure.TmsLink;
import io.qameta.allure.Description;
import org.selenium.dto.UserAccount;
import org.selenium.helpers.PageUtil;
import org.selenium.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.selenium.page.CreateAnAccountPage;

@Listeners(TestListener.class)
public class CreateAnAccountTest extends BaseTest {

    private UserAccount randomUsersCreator;

    @BeforeMethod
    public void getData() {
        randomUsersCreator = new UserAccount().createFakeAccount();
    }

    @Description("Create account functionality")
    @TmsLink("ID-001")
    @Test
    public void createAnAccountTest() {
        CreateAnAccountPage createAnAccountPage = homePage.clickCreateAccountLink();
        createAnAccountPage.fillInCreateAccountFields(randomUsersCreator);
        Assert.assertTrue(PageUtil.isDisplayed(createAnAccountPage.
                createAccountButtonClick().successfullyAddedAddressMessage),
                "Account has not been created");
    }
}