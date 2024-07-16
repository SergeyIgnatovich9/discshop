import io.qameta.allure.TmsLink;
import io.qameta.allure.Description;
import org.selenium.helpers.PageUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.selenium.page.LoginPage;
import org.selenium.report.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Description("Login and navigation to Welcome screen")
    @TmsLink("ID-002")
    @Test
    public void signInTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        Assert.assertFalse(PageUtil.isDisplayed(homePage.welcomeMessage),
                "Deliberately broken test for reporting demonstration");
    }
}
