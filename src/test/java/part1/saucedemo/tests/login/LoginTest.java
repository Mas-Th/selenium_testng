package part1.saucedemo.tests.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;


public class LoginTest extends BaseTest {

    @Test
    void testLoginValid(){
        By titleProduct = By.xpath("//div[contains(@class, 'header_secondary_container')]//span[contains(text(), 'Products')]");
        loginPage.loginToApplication("standard_user", "secret_sauce");
        String textTitle = basePage.getText(titleProduct);
        Assert.assertEquals(textTitle, "Products", "Not equals");
    }

    @Test
    public void testLoginErrorMessage(){
        loginPage.loginToApplication("standard_user", "secret_sauced");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface"));
    }
    @Test
    public void testLoginUserBlackErrorMessage(){
        loginPage.loginToApplication("", "secret_sauced");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username is required"));
    }

    @Test
    public void testLoginPassBlankErrorMessage(){
        loginPage.loginToApplication("standard_user", "");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Password is required"));
    }

    @Test
    public void testLoginBlankErrorMessage(){
        loginPage.loginToApplication("     ","       ");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));
    }



}
