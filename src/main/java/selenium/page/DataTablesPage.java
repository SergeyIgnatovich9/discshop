package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataTablesPage extends BasePage {
    private static final By FIRST_NAME_HEADER_LOCATOR = By.xpath
            ("//table[@id='table1']//span[contains (text(), 'First Name')]");
    private static final By FIRST_NAMES_LOCATOR = By.cssSelector("#table1 td:nth-of-type(2)");
    private static final By DATATABLES_TITLE = By.xpath("//h3[contains (text(), 'Data Tables')]");

    public WebElement getDataTablesTitle() {
        return driver.findElement(DATATABLES_TITLE);
    }

    public void clickFirstNameHeader() {
        driver.findElement(FIRST_NAME_HEADER_LOCATOR).click();
    }

    public List<String> getFirstNameValues() {
        return new ArrayList<>(driver.findElements(FIRST_NAMES_LOCATOR).stream().map(WebElement::getText).toList());
    }
}