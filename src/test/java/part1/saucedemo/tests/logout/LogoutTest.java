package part1.saucedemo.tests.logout;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import part1.saucedemo.base.BaseTest;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import java.util.Set;



public class LogoutTest extends BaseTest {
    @Test
    public void testLogoutApp(){
        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");
//        productPage.
    }



    @Test(priority = 1)
    public void shouldHaveValidCookieWhenLoggedIn() {
        var productPage = loginPage.loginToApplication("standard_user", "secret_sauce");

        Cookie sessionCookie = driver.manage().getCookieNamed("session-username");
        Assert.assertNotNull(sessionCookie, "Session cookie not found!");

        Date expiry = sessionCookie.getExpiry();
        if (expiry != null) {
            Assert.assertTrue(expiry.after(new Date()), "Cookie is already expired!");
        }
    }

    @Test(priority = 2)
    public void shouldLogoutWhenCookieExpired() {
        Cookie expiredCookie = new Cookie.Builder("session-username", "standard_user")
                .domain("www.saucedemo.com")
                .path("/")
                .expiresOn(Date.from(Instant.now().minusSeconds(60)))
                .isHttpOnly(false)
                .isSecure(false)
                .build();
        // delete old cookie
        driver.manage().deleteCookieNamed("session-username");
        // create new cookie
        driver.manage().addCookie(expiredCookie);

        driver.navigate().refresh();

        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("saucedemo.com"), "URL mismatch after cookie expired");

    }

    @Test(priority = 3)
    public void shouldDecodeJWTIfPresent() {
        Cookie sessionCookie = driver.manage().getCookieNamed("session-username");
        if (sessionCookie != null && sessionCookie.getValue().split("\\.").length == 3) {
            String[] parts = sessionCookie.getValue().split("\\.");
            String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

            System.out.println("JWT Payload: " + payloadJson);
            Assert.assertTrue(payloadJson.contains("exp"), "JWT payload does not contain exp");
        } else {
            System.out.println("Cookie is not JWT format. Value: " + (sessionCookie != null ? sessionCookie.getValue() : "null"));
        }
    }

    @Test(priority = 4)
    public void shouldCheckHttpOnlyAndSecureFlags() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        Cookie sessionCookie = driver.manage().getCookieNamed("session-username");
        Assert.assertNotNull(sessionCookie, "Session cookie not found!");
        System.out.println("HttpOnly: " + sessionCookie.isHttpOnly());
        System.out.println("Secure: " + sessionCookie.isSecure());
    }

    @Test(priority = 5)
    public void shouldLogoutAfterDeletingAllCookies() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        Set<Cookie> cookiesAfter = driver.manage().getCookies();
        Assert.assertTrue(cookiesAfter.isEmpty(), "Cookies should be empty after deletion");
    }

    @Test(priority = 6)
    void ShouldRedirectLoginPageIfNotLogin(){
        // cookie
        driver.manage().deleteAllCookies();

        driver.get("https://www.saucedemo.com/inventory.html");

        String currentUrl = driver.getCurrentUrl();

        // or local storage, session need use JS
        // ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        // ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");

        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.contains("https://www.saucedemo.com"), "Not Redirect LoginPage");

        By errorMessage = By.xpath("//div[contains(@class, 'error-message-container')]//h3[@data-test='error']");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        String textErrorBtn = basePage.getText(errorMessage);
        System.out.println(textErrorBtn);
        Assert.assertTrue(textErrorBtn.contains("Epic sadface: You can only access '/inventory.html' when you are logged in."), "Text Other");

    }
}
