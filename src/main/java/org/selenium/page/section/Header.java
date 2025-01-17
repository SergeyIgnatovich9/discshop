package org.selenium.page.section;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.page.BasePage;
import org.selenium.page.CartPage;
import org.selenium.page.Index_Page;
import java.util.List;

public class Header extends BasePage {

    @FindBy(css = "a.level-top")
    private List<WebElement> menuCategories;

    @FindBy (css = ".submenu .category-item a")
    private List<WebElement> subMenuCategories;

    @FindBy (xpath = "//a[@class='action showcart']")
    private WebElement cartButton;

    @FindBy (xpath = "//a[@class='action viewcart']")
    private WebElement cartViewButton;

    public CartPage clickCartButton() {
        waitForElementLocated(cartButton);
        cartButton.click();
        waitForElementLocated(cartViewButton);
        cartViewButton.click();
        return new CartPage();
    }

    public Index_Page choseCategoryMenu(String category, String... subCategories) {
        WebElement targetMenu = menuCategories.stream().filter(element -> element.getText().equals(category)).
                findFirst().orElseThrow(RuntimeException::new);
        hover(targetMenu);
        if (!ArrayUtils.isEmpty(subCategories)) {
            for (String subCategory : subCategories) {
                targetMenu = subMenuCategories.stream().filter(element -> element.getText().equals(subCategory)).
                        findFirst().orElseThrow(RuntimeException::new);
                hover(targetMenu);
            }
        }
        targetMenu.click();
        return new Index_Page();
    }
}
