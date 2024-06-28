package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoading {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_loading";
    private static final By LINK_1 = By.cssSelector("[href='/dynamic_loading/1']");
    private static final By START_BUTTON = By.cssSelector("div#start button");
    private static final By FINISH_MESSAGE = By.cssSelector("div#finish");

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
    }

    @Test
    public void DynamicLoadTest() {
        driver.findElement(LINK_1).click();
        driver.findElement(START_BUTTON).click();
        WebElement finishMessage = driver.findElement(FINISH_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(finishMessage));
        String actualText = finishMessage.getText();
        Assert.assertTrue(finishMessage.isDisplayed());
        Assert.assertEquals(actualText, "Hello World!");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
