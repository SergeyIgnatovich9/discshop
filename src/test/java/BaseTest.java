import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.selenium.driver.DriverManager;
import org.selenium.page.HomePage;
import org.selenium.report.AllureManager;
import org.selenium.report.TestListener;
import java.time.Duration;
import static org.selenium.config.ConfigurationManager.configuration;

@Listeners(TestListener.class)

public class BaseTest {

    protected HomePage homePage;
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod
    public void startBrowser() {
        driver = DriverManager.getDriver();
        driver.get(configuration().url());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverManager.tearDown();
    }
}
