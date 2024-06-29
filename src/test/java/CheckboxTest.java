import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.page.CheckboxPage;

public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void goToCheckboxPage() {
        checkboxPage = homePage.navigateToCheckboxPage();
    }

    @Test
    public void navigationCheckboxTest() {
        Assert.assertTrue(checkboxPage.getCheckBoxTitle().isDisplayed());
    }

    @Test
    public void checkboxDefaultConditionTest() {
        Assert.assertFalse(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }

    @Test
    public void selectedCheckboxTest() {
        checkboxPage.selectCheckbox(CheckboxPage.Checkbox.FIRST);
        checkboxPage.selectCheckbox(CheckboxPage.Checkbox.SECOND);
        Assert.assertTrue(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }
}
