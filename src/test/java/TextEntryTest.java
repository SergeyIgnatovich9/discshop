import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextEntryTest {
    private WebDriver driver;
    private static final String URL = "http://the-internet.herokuapp.com/iframe";
    private static final By CONTENT_BODY = By.id("tinymce");
    private static final String FRAME_ID = "mce_0_ifr";
    private static final String CUSTOM_TEXT = "Hello World!";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void frameTest() {
        driver.switchTo().frame(FRAME_ID);
        WebElement contentBody = driver.findElement(CONTENT_BODY);
        contentBody.clear();
        contentBody.sendKeys(CUSTOM_TEXT);
        Assert.assertEquals(CUSTOM_TEXT, contentBody.getText());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}