package part1.saucedemo.pages;

import org.openqa.selenium.By;
import base.BasePage;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private final By linkImg = By.id("inventory_sidebar_link");
    private final By linkCart = By.xpath("//div[contains(@id, 'shopping_cart_container')]//a[contains(@data-test,'shopping-cart-link')]");

    By addCartItem01 = By.id("add-to-cart-sauce-labs-backpack");
    By addCartItem02 = By.id("add-to-cart-sauce-labs-bike-light");
    By addCartItem03 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addCartItem06 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    By removeCartItem06 = By.id("remove-test.allthethings()-t-shirt-(red)");



    public ProductDetail clickLinkImg(){
        find(linkImg);
        return new ProductDetail();
    }

    public CartPage clickLinkCart(){
        find(linkCart).click();
        return new CartPage();
    }

    public void clickAddCarts(){
        find(addCartItem01).click();
        find(addCartItem02).click();
        find(addCartItem03).click();
        find(addCartItem06).click();
    }



}
