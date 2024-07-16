import io.qameta.allure.TmsLink;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.helpers.PageUtil;
import org.selenium.page.CartPage;
import org.selenium.page.LoginPage;
import org.selenium.report.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static org.selenium.helpers.Const.*;

@Listeners(TestListener.class)
public class AddProductToCartTest extends BaseTest {

    @Description("Add products to cart + values check")
    @TmsLink("ID-005")
    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        homePage.getHeader().choseCategoryMenu
                (WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY,PANTS_SUB_CATEGORY).selectARandomProduct().addProdToCart();
        homePage.getHeader().choseCategoryMenu
                (MAN_CATEGORY, TOPS_SUB_CATEGORY,JACKETS_SUB_CATEGORY).selectARandomProduct().addProdToCart();
        homePage.getHeader().choseCategoryMenu
                (WOMEN_CATEGORY, TOPS_SUB_CATEGORY,JACKETS_SUB_CATEGORY).selectARandomProduct().addProdToCart();
        new WebDriverWait(driver, Duration.ofSeconds(20));
        CartPage cartPage = homePage.getHeader().clickCartButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(PageUtil.isDisplayed(cartPage.cartPageTitle), "Page not found");
        softAssert.assertTrue(cartPage.checkOrderTotals(), "Values does not match");
        softAssert.assertAll();
    }
}
