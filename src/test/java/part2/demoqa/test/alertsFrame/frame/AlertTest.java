package frame;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

import java.time.Duration;

import static base.BasePage.delay;

public class AlertTest extends BaseTest {

    @Test
    public  void testClickBtnAlert() throws InterruptedException {

        String expectedAlertText = "You clicked a button";
        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnAlert();


        var alert = driver.switchTo().alert();
        delay(1000);

        Assert.assertEquals(getAlertText(), expectedAlertText, "Actual and Expected Do Not Math Text ");
        alert.accept();
    }

    @Test
    public  void testClickBtnAlertAppear5Seconds() throws InterruptedException {

        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnAlertAppear5Seconds();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());

        var alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public  void testClickConfirmBtnCancel() throws InterruptedException {
        By eAlertConfirmBtnResult = By.xpath("//div[@id='javascriptAlertsWrapper']//span[@id='confirmResult']");

        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnConfirm();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        var alert = driver.switchTo().alert();
        alert.dismiss();

        String e = driver.findElement(eAlertConfirmBtnResult).getText();
        Assert.assertTrue(e.contains("Cancel"), "Click Confirm ##");
    }

    @Test
    public  void testClickConfirmBtnOk() throws InterruptedException {
        By eAlertConfirmBtnResult = By.xpath("//div[@id='javascriptAlertsWrapper']//span[@id='confirmResult']");

        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnConfirm();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        var alert = driver.switchTo().alert();
        alert.accept();

        String eResult = driver.findElement(eAlertConfirmBtnResult).getText();
        Assert.assertTrue(eResult.contains("Ok"), "Click Confirm ##");
    }

    @Test
    public  void testClickPromptBtnOk() throws InterruptedException {
        By eAlertPromptBtnResult = By.xpath("//div[@id='javascriptAlertsWrapper']//span[@id='promptResult']");

        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnPrompt();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        var alert = driver.switchTo().alert();
        alert.sendKeys("nameee");
        alert.accept();

        String eResult = driver.findElement(eAlertPromptBtnResult).getText();
        Assert.assertTrue(eResult.contains("nameee"), "Click Confirm ##");
    }

    @Test
    public  void testClickPromptBtnCancel() throws InterruptedException {
        By eAlertPromptBtnResult = By.xpath("//div[@id='javascriptAlertsWrapper']//span[@id='promptResult']");

        var alertCard = homePage.goToAlertFrameWindowPage().clickAlert();
        alertCard.clickBtnPrompt();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        var alert = driver.switchTo().alert();
        alert.dismiss();

        try {
            WebElement eResult = driver.findElement(eAlertPromptBtnResult);
            String text = eResult.getText();
            Assert.assertTrue(text.isEmpty(), "Hiển thị nội dung là failed");
        } catch (NoSuchElementException ex) {
            // Element không tồn tại (=> đúng như kỳ vọng: không hiển thị)
            Assert.assertTrue(true);
        }
    }
}
