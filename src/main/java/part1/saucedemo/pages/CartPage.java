package part1.saucedemo.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends ProductPage {
    By btnCheckOut = By.id("checkout");

    public void clickCheckOut(){
        find(btnCheckOut).click();
        new CheckOutPage();
    }

    public void clickRemoveCartItem(By locator){
        driver.findElement(locator).click();
    }

}
