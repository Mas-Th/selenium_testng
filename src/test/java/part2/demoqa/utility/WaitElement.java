package part2.demoqa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static base.BasePage.driver;

public class WaitElement {

    /**
     * Đợi đến khi phần tử có ID chỉ định hiển thị (visible)
     */
    public static void waitElementById(By id) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(id));
    }

    /**
     * Đợi đến khi phần tử có XPath chỉ định hiển thị (visible)
     */
    public static void waitElementByXPath(By xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    /**
     * Đợi phần tử có thể được click (enabled và visible)
     * → Dùng trước khi gọi click()
     */
    public static void waitClickableLocator(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Đợi phần tử biến mất khỏi giao diện (invisible)
     * → Dùng để đợi loading spinner, dialog đóng, v.v.
     */
    public static void waitInvisibleLocator(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Đợi đoạn text xuất hiện trong phần tử
     * → Dùng để kiểm tra thông báo, kết quả, tiêu đề v.v.
     */
    public static void waitTextPresentLocator(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Đợi alert (popup hệ thống JS) hiển thị
     * → Dùng với Alert Accept / Dismiss
     */
    public static void waitAlertPresent() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Đợi ít nhất 1 phần tử tồn tại trong danh sách (list element)
     * → Dùng để kiểm tra danh sách kết quả có load chưa
     */
    public static void waitElementsPresent(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(driver -> !driver.findElements(locator).isEmpty());
    }

    /**
     * Đợi frame (iframe) sẵn sàng và chuyển context vào frame
     * → Dùng khi thao tác với nội dung trong iframe
     */
    public static void waitAndSwitchToFrame(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    /**
     * Đợi giá trị attribute của phần tử chứa một đoạn giá trị mong muốn
     * → Dùng để đợi trạng thái class thay đổi, ví dụ "class=loading done"
     */
    public static void waitAttributeContains(By locator, String attr, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.attributeContains(locator, attr, value));
    }

    /**
     * Đợi phần tử có giá trị CSS cụ thể
     * → Dùng để xác định trạng thái visual: màu, visibility, v.v.
     */
    public static void waitCssValue(By locator, String cssProperty, String expectedValue) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(driver -> driver.findElement(locator).getCssValue(cssProperty).equals(expectedValue));
    }


    public ExpectedCondition<Boolean> elementHasText(By locator, String expectedText){
        return driver -> {
            assert driver != null;
            return driver.findElement(locator).getText().equals(expectedText);
        };
    }

    // Fluent wait detail
    public WebElement waitWithFluent(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);


        return wait.until( driver -> {
            WebElement el = driver.findElement(locator);
            return el.isDisplayed() ? el : null;
        });
    }

}




