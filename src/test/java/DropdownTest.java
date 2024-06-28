import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {

    private WebDriver driver;
    private static final String URL = "http://the-internet.herokuapp.com/dropdown";
    private static final By DROPDOWN = By.cssSelector("#dropdown");
    private static final String EXPECTED_OPTION_1 = "Option 1";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void dropdownOptionsTest() {
        WebElement dropdown = driver.findElement(DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        String actualSelectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOption, EXPECTED_OPTION_1);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
