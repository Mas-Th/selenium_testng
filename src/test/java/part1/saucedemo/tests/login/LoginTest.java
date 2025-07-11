package part1.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;


public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage() throws InterruptedException {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauced");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface"));

    }
    @Test
    public void testLoginUserBlackErrorMessage() throws InterruptedException {
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauced");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username is required"));

    }

    @Test
    public void testLoginPassBlankErrorMessage() throws InterruptedException {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Password is required"));

    }

    @Test
    public void testLoginBlankErrorMessage() throws InterruptedException {
        loginPage.setUsername("           ");
        loginPage.setPassword("        ");
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));

    }

}
