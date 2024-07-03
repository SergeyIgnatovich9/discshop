import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.page.ForgotYourPasswordPage;

public class ForgotYourPasswordTest extends BaseTest {
    ForgotYourPasswordPage forgotYourPasswordPage;

    @Test
    public void signInTest() {
        forgotYourPasswordPage = homePage.clickSignInLink().clickForgotYourPasswordLink();
        Assert.assertTrue(forgotYourPasswordPage.forgotYourPasswordButtonIsDisplayed());
    }
}
