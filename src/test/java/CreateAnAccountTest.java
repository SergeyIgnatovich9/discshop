import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.CreateAnAccountPage;

public class CreateAnAccountTest extends BaseTest {
    @Test
    public void createAnAccountNavigation() {
        CreateAnAccountPage createAnAccountPage = homePage.clickCreateAnAccountLink();
        Assert.assertTrue(createAnAccountPage.createAnAccountPageIsDisplayed());
    }
}
