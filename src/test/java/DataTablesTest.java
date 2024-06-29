import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.page.DataTablesPage;

import java.util.Collections;
import java.util.List;

public class DataTablesTest extends BaseTest {
    private DataTablesPage dataTablesPage;

    @BeforeMethod
    public void goToDataTablesPage() {
        dataTablesPage = homePage.navigateToDataTablesPage();
    }

    @Test
    public void navigationDataTablesTest() {
        Assert.assertTrue(dataTablesPage.getDataTablesTitle().isDisplayed());
    }

    @Test
    public void fistNamesSorting() {
        List<String> expectedFirstNamesValues = dataTablesPage.getFirstNameValues();
        Collections.sort(expectedFirstNamesValues);
        dataTablesPage.clickFirstNameHeader();
        List<String> actualFirstNamesValues = dataTablesPage.getFirstNameValues();
        Assert.assertEquals(actualFirstNamesValues, expectedFirstNamesValues);
    }
}