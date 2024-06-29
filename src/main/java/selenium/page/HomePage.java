package selenium.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By CHECKBOX_LINK = By.cssSelector("[href *='checkboxes']");
    private static final By DATA_TABLE_LINK = By.cssSelector("[href *='tables']");

    public CheckboxPage navigateToCheckboxPage() {
        driver.findElement(CHECKBOX_LINK).click();
        return new CheckboxPage();
    }

    public DataTablesPage navigateToDataTablesPage() {
        driver.findElement(DATA_TABLE_LINK).click();
        return new DataTablesPage();
    }
}
