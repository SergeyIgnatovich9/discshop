import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.config.TestConfig;
import selenium.data.DataProviderClass;
import selenium.page.LoginPage;

public class LoginTest extends BaseTest {
    private static final String EMAIL = TestConfig.get("login.email");
    private static final String PASSWORD = TestConfig.get("login.password");
    private static final String INCORRECT_EMAIL = TestConfig.get("login.email.incorrect");
    private static final String INCORRECT_FORMAT_EMAIL = TestConfig.get("login.email.incorrectFormat");
    private static final String INCORRECT_EMAIL_ERROR_MESSAGE = TestConfig.get("errorMessage.incorrectEmail");
    private static final String REQUIRED_FIELD_ERROR_MESSAGE = TestConfig.get("errorMessage.requiredField");
    private static final String WRONG_CREDS_ERROR_MESSAGE = TestConfig.get("errorMessage.wrongCreds");
    public LoginPage loginPage;

    @BeforeMethod
    public void goToSignInPage() {
        loginPage = homePage.clickSignInLink();
    }

    @Test
    public void signInTest() {
        loginPage.fillInEmail(EMAIL);
        loginPage.fillInPassword(PASSWORD);
        homePage = loginPage.clickSingInButton();
        Assert.assertTrue(homePage.welcomMessageDisplayed());
    }

    @Test
    public void incorrectEmailTest() {
        loginPage.fillInEmail(INCORRECT_EMAIL);
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickSingInButton();
        Assert.assertEquals(loginPage.getErrorMessageWrongCredsText(),
                WRONG_CREDS_ERROR_MESSAGE);
    }

    @Test
    public void requiredFieldsTest() {
        loginPage.clickSingInButton();
        Assert.assertEquals(loginPage.getEmailErrorMessageText(), REQUIRED_FIELD_ERROR_MESSAGE);
        Assert.assertEquals(loginPage.getPasswordErrorMessageText(), REQUIRED_FIELD_ERROR_MESSAGE);
    }

    @Test
    public void incorrectEmailFormatTest() {
        loginPage.fillInEmail(INCORRECT_FORMAT_EMAIL);
        loginPage.fillInPassword(PASSWORD);
        loginPage.clickSingInButton();
        Assert.assertEquals(loginPage.getEmailErrorMessageText(),
                INCORRECT_EMAIL_ERROR_MESSAGE);
    }

    @Test(dataProvider = "invalidSignInData", dataProviderClass = DataProviderClass.class)
    public void invalidSignInDDTTest(String invalidPassword) {
        loginPage.fillInEmail(EMAIL);
        loginPage.fillInPassword(invalidPassword);
        homePage = loginPage.clickSingInButton();
        Assert.assertEquals(loginPage.getErrorMessageWrongCredsText(), WRONG_CREDS_ERROR_MESSAGE);
    }
}
