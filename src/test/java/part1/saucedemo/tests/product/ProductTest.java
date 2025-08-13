package part1.saucedemo.tests.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;

import java.time.Duration;

public class ProductTest extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test
    void testProductsHeaderIsDisplayed(){
        loginPage.loginToApplication("standard_user", "secret_sauce");
        By productsHeader = By.xpath("//span[text()='Products']");
        String titleProduct = basePage.getText(productsHeader);
        Assert.assertEquals(titleProduct, "Products", "\nProduct Header is displayed\n");
    }

    @Test
    void testDetailProDuct(){
        By titleDetailProduct = By.id("back-to-products");

        String textDetailProduct = basePage.getText(titleDetailProduct);
        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickLinkImg();

        Assert.assertEquals(textDetailProduct, "Back to products", "Not Page Detail");
    }


    @Test
    void testClickProductItem() {
        By addCartItem06 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
        By removeCartItem06 = By.id("remove-test.allthethings()-t-shirt-(red)");

        loginPage.loginToApplication("standard_user", "secret_sauce");

        // Click Add
        WebElement addBtn = driver.findElement(addCartItem06);
        addBtn.click();

        // wait Add button staleness
        getWait().until(ExpectedConditions.stalenessOf(addBtn));

        // wait Remove button appear
        WebElement removeBtn = getWait().until(ExpectedConditions.visibilityOfElementLocated(removeCartItem06));
        Assert.assertEquals(removeBtn.getText(), "Remove", "Not Text Remove");

        // Click Remove
        removeBtn.click();

        // wait Remove button staleness
        getWait().until(ExpectedConditions.stalenessOf(removeBtn));

        // wait Add button staleness
        WebElement addBtnBack = getWait().until(ExpectedConditions.visibilityOfElementLocated(addCartItem06));
        Assert.assertEquals(addBtnBack.getText(), "Add to cart", "Not Text Add");
    }

    @Test
    void testProductItemAddCart(){
        By addProductAddCart = By.xpath("//div[contains(@id, 'shopping_cart_container')]//a//span[contains(@class, 'shopping_cart_badge')]");

        loginPage.loginToApplication("standard_user", "secret_sauce").clickAddCarts();

        String num = basePage.getText(addProductAddCart);

        Assert.assertEquals(num, "4", "Not result");



    }

}
