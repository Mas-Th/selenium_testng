package part1.saucedemo.pages;

import org.openqa.selenium.By;
import base.BasePage;

public class ProductPage extends BasePage {
    private final By productsHeader = By.xpath("//span[text()='Products']");

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }
}
