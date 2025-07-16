package part2.demoqa.test.alertsFrame.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class BrowserTest extends BaseTest {
    @Test
    public void testBrowserNewTab(){
        var browserForm = homePage.goToAlertFrameWindowPage().clickBrowser();
        // Save handle window present
        String originalTab = driver.getWindowHandle();
        // click btn
        browserForm.clickBtnNewTab();
        // wait tab appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // switch to new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles){
            if(!handle.equals(originalTab)){
                driver.switchTo().window(handle);
                break;
            }
        }

        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("https://demoqa.com/sample"));

    }

    @Test
    public void testBrowserNewWindow(){
        var browserForm = homePage.goToAlertFrameWindowPage().clickBrowser();

        String originalWindow = driver.getWindowHandle();
        browserForm.clickBtnNewWindow();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver -> driver.getWindowHandles().size() > 1);

        // switch to new tab

        for (String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String textMess = driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(textMess.contains("This is a sample page"), "No Mess");


        // close and go back window
        driver.switchTo().window(originalWindow);

    }

    @Test
    public void testBrowserNewWindowMessage(){
        var browserForm = homePage.goToAlertFrameWindowPage().clickBrowser();

        String originalWindow = driver.getWindowHandle();

        browserForm.clickBtnNewWindowMessage();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver -> driver.getWindowHandles().size() > 1);

        // switch to new tab

        for (String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // close and go back window
        driver.switchTo().window(originalWindow);

    }
}
