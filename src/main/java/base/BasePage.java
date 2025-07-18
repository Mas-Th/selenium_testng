package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).sendKeys(text);
        find(locator).clear();
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public static void delay(int miliseconds) throws InterruptedException {
        try{
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
