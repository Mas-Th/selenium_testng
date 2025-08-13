package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void setText(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator){
        try {
            return find(locator).isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public static void delay(int milliseconds) throws InterruptedException {
        try{
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }

    public void delay(long x) throws InterruptedException {
        Thread.sleep(x);
    }
}
