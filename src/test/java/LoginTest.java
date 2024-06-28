import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "ignat@ignat.com";
    private static final String PASSWORD = "123QWEqwe";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension( 1000, 800));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(300));
    }
    @Test
    public void signInTest() {
        By signInlocator = By.xpath("//li/a[contains(text(), 'Sign In')]");
        WebElement signInMain = driver.findElement(signInlocator);
        signInMain.click();

        By emailFieldLocator = By.xpath("//input[@name='login[username]']");
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(EMAIL);

        By passwordFieldLocator = By.xpath("//input[@name='login[password]']");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(PASSWORD);

        By signInButtonlocator = By.xpath("//*[@id='send2'][@class='action login primary']");
        WebElement signInButton = driver.findElement(signInButtonlocator);
        signInButton.click();

        By welcomeMessageLocator = By.xpath("//span[contains(text(),'Welcome')]");
        WebElement welcocmeMessage = driver.findElement(welcomeMessageLocator);
        Assert.assertTrue(welcocmeMessage.isDisplayed());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
