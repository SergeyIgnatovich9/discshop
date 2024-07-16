import io.qameta.allure.TmsLink;
import io.qameta.allure.Description;
import org.selenium.helpers.PageUtil;
import org.selenium.page.*;
import org.selenium.page.ProductDetailsPage;
import org.selenium.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.selenium.helpers.Const.*;

@Listeners(TestListener.class)
public class AddToWishListTest extends BaseTest{

    @Description("Add a product to wish list")
    @TmsLink("ID-004")
    @Test
    public void addAddressTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        Index_Page index_page = homePage.getHeader().choseCategoryMenu
                (WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY,PANTS_SUB_CATEGORY);
        ProductDetailsPage productDetailsPage = index_page.selectARandomProduct();
        productDetailsPage.addToWishList();
        Assert.assertTrue(PageUtil.isDisplayed(productDetailsPage.successfullyAddedToWishMessage),
                "Could not add the product to wish list");
    }
}
