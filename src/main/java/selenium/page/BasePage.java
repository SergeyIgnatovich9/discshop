package selenium.page;

import org.openqa.selenium.WebDriver;
import selenium.driver.DriverManager;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }
}
