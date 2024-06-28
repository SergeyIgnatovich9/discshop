import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class HoverTest {
    private WebDriver driver;
    private static final String URL = "http://the-internet.herokuapp.com/hovers";
    private static final By AVATAR = By.cssSelector(".figure img");
    private static final By VIEW_PROFILE_LINK = By.cssSelector(".figure a");
    private static final By AVATAR_TEXT = By.cssSelector(".figure h5");
    private static final By PROFILE = By.cssSelector("h1");
    private static final String EXPECTED_PROFILE_TEXT = "Not Found";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void profileTextTest() {
        List<WebElement> avatars = driver.findElements(AVATAR);
        List<WebElement> links = driver.findElements(VIEW_PROFILE_LINK);
        Actions actions = new Actions(driver);
        actions.moveToElement(avatars.get(0)).perform();
        links.get(0).click();
        WebElement profile = driver.findElement(PROFILE);
        String actualProfileText = profile.getText();
        Assert.assertEquals(EXPECTED_PROFILE_TEXT, actualProfileText);
    }

    @Test
    public void profileLinksTest() {
        List<WebElement> avatars = driver.findElements(AVATAR);
        List<WebElement> avatarLinks = driver.findElements(VIEW_PROFILE_LINK);
        Actions actions = new Actions(driver);
        IntStream.range(0, 3).forEach(i -> {
            actions.moveToElement(avatars.get(i)).perform();
            Assert.assertTrue(avatarLinks.get(i).isDisplayed());
        });
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
