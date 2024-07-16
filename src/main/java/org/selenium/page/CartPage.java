package org.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.helpers.PageUtil;
import java.util.List;
import java.util.stream.DoubleStream;

public class CartPage extends BasePage {

    @FindBy(css = ".page-title")
    public WebElement cartPageTitle;

    @FindBy(css = ".item-info .subtotal .price")
    private List<WebElement> itemsSubtotalLoc;

    @FindBy(css = ".data .sub .price")
    private WebElement generalSubtotalLoc;

    @FindBy(css = ".data .grand .price")
    private WebElement generalTotalLoc;

    @FindBy(xpath = "//*[@data-th='Discount']")
    private WebElement generalDiscountLoc;

    @FindBy(css = ".data .totals-tax .price")
    private WebElement generalTaxLoc;

    public boolean checkOrderTotals() {
        double prodSum = itemsSubtotalLoc.stream().map(element -> PageUtil.extractNumberFromString(element.getText()))
                .flatMapToDouble(el -> DoubleStream.of(Double.parseDouble(el))).sum();
        waitForElementLocated(generalSubtotalLoc);
        double subtotal = Double.parseDouble(PageUtil.extractNumberFromString(generalSubtotalLoc.getText()));
        double discount = Double.parseDouble(PageUtil.extractNumberFromString(generalDiscountLoc.getText()));
        double tax = Double.parseDouble(PageUtil.extractNumberFromString(generalTaxLoc.getText()));
        double total = Double.parseDouble(PageUtil.extractNumberFromString(generalTotalLoc.getText()));
        return ((prodSum - discount + tax) == total) & (prodSum == subtotal);
    }
}