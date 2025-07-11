package part1.saucedemo.tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;
import part1.saucedemo.pages.ProductPage;

public class ProductTest extends BaseTest {
    @Test
    public void testProductsHeaderIsDisplayed(){
        ProductPage productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
        Assert.assertTrue(productPage.isProductsHeaderDisplayed(), "\nProduct Header is displayed\n");
    }
}
