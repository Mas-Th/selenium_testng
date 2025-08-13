package part1.saucedemo.tests.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;

import java.util.List;
import java.util.logging.Level;

import static utilities.JavascriptUtility.clickReload;

public class CartTest extends BaseTest {
    private final By titleCartPage = By.xpath("//div[contains(@id, 'header_container')]//span[contains(text(), 'Your Cart')]");

    @Test
    void testCartPageIsDisplayed(){
        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickLinkCart();
        String textTitleCartPage = basePage.getText(titleCartPage);
        Assert.assertEquals(textTitleCartPage, "Your Cart", "Not Cart Page");
    }

    @Test
    void testCartPageItemEmpty(){
        loginPage.loginToApplication("standard_user", "secret_sauce").clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );
        Assert.assertEquals(cartItems.size(), 0, "Not Empty");
    }

    @Test
    void testShouldNotCashUICartPage() {

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
         var cartPage = productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(!cartItems.isEmpty()){
            By itemCart01 = By.id("remove-sauce-labs-backpack");
            By itemCart02 = By.id("remove-sauce-labs-bike-light");
            By itemCart03 = By.id("remove-sauce-labs-bolt-t-shirt");
            By itemCart06 = By.id("remove-test.allthethings()-t-shirt-(red)");

            cartPage.clickRemoveCartItem(itemCart01);
            cartPage.clickRemoveCartItem(itemCart02);
            cartPage.clickRemoveCartItem(itemCart03);
            cartPage.clickRemoveCartItem(itemCart06);

            getWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]"), 0));

            List<WebElement> updatedCartItems = driver.findElements(
                    By.xpath("//div[contains(@class, 'cart_item')]")
            );
            Assert.assertEquals(updatedCartItems.size(),0, "Other quantity");

            try{
                boolean isRemoved = getWait().until(
                        ExpectedConditions.invisibilityOfAllElements(cartItems));

                if (isRemoved) {
                    System.out.println("✅ Tất cả cart_item đã biến mất khỏi DOM.");
                } else {
                    System.out.println("❌ Vẫn còn cart_item trong DOM.");
                }

            } catch (TimeoutException ex){
                System.out.println("❌ Timeout! Exist item");
            }
        }
    }

    @Test
    void testShouldNotErrorJSCartPage() {

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
        productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(cartItems.isEmpty()){
            LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
            boolean hasError = logs.getAll().stream()
                    .anyMatch(entry -> entry.getLevel().equals(Level.SEVERE));
            if (hasError) {
                throw new AssertionError("Có lỗi JavaScript trong console.");
            }
            System.out.println("✅ Không có lỗi JS trong console.");
        }
    }

    @Test
    void testAddCartItem(){

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
        productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(!cartItems.isEmpty()){
            Assert.assertEquals(cartItems.size(),4, "other quantity");
        }

    }

    @Test
    void testRemoveOneCartItem(){

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
        var cartPage = productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(!cartItems.isEmpty()){

            By itemCart = By.id("remove-sauce-labs-bike-light");

            Assert.assertEquals(cartItems.size(), 4, "Initial cart should have 4 items.");

            cartPage.clickRemoveCartItem(itemCart);

            getWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]"), 3));
            List<WebElement> updatedCartItems = driver.findElements(
                    By.xpath("//div[contains(@class, 'cart_item')]")
            );
            Assert.assertEquals(updatedCartItems.size(),3, "Other quantity");
        }
    }

    @Test
    void testRemoveAllCartItem(){

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
        var cartPage = productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(!cartItems.isEmpty()){
            By itemCart01 = By.id("remove-sauce-labs-backpack");
            By itemCart02 = By.id("remove-sauce-labs-bike-light");
            By itemCart03 = By.id("remove-sauce-labs-bolt-t-shirt");
            By itemCart06 = By.id("remove-test.allthethings()-t-shirt-(red)");


            Assert.assertEquals(cartItems.size(), 4, "Initial cart should have 4 items.");

            cartPage.clickRemoveCartItem(itemCart01);
            cartPage.clickRemoveCartItem(itemCart02);
            cartPage.clickRemoveCartItem(itemCart03);
            cartPage.clickRemoveCartItem(itemCart06);

            getWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]"), 0));
            List<WebElement> updatedCartItems = driver.findElements(
                    By.xpath("//div[contains(@class, 'cart_item')]")
            );

            Assert.assertEquals(updatedCartItems.size(),0, "Other quantity");
        }
    }

    @Test
    void testRemoveAllCartItemAndReload(){

        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.clickAddCarts();
        var cartPage = productPage.clickLinkCart();

        List<WebElement> cartItems = driver.findElements(
                By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]")
        );

        if(!cartItems.isEmpty()){
            By itemCart01 = By.id("remove-sauce-labs-backpack");
            By itemCart02 = By.id("remove-sauce-labs-bike-light");
            By itemCart03 = By.id("remove-sauce-labs-bolt-t-shirt");
            By itemCart06 = By.id("remove-test.allthethings()-t-shirt-(red)");

            cartPage.clickRemoveCartItem(itemCart01);
            cartPage.clickRemoveCartItem(itemCart02);
            cartPage.clickRemoveCartItem(itemCart03);
            cartPage.clickRemoveCartItem(itemCart06);

            Assert.assertEquals(cartItems.size(), 4, "Initial cart should have 4 items.");

            clickReload();
            getWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'cart_item')]//div[contains(@class, 'cart_item_label')]"), 0 ));

            List<WebElement> updatedCartItems = driver.findElements(
                    By.xpath("//div[contains(@class, 'cart_item')]")
            );

            Assert.assertEquals(updatedCartItems.size(),0, "Other quantity");
        }
    }





}
