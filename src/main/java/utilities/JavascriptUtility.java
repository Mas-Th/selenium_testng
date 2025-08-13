package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptUtility extends Utility {

    /**
     *
     * @param locator scroll
     */
    public static void scrollToElementJs(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll element vào view
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Scroll thêm xuống 60px
        js.executeScript("window.scrollBy(0, -80);");
    }
    // click element DOM
    public static void clickJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public static void clickReload(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location,reload()");
    }

    // highlight element DOM
    public static void highlight(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            executor.executeScript("arguments[0].style.border='3px solid red'", element);
            try { Thread.sleep(300); } catch (InterruptedException e) {}
            executor.executeScript("arguments[0].style.border=''", element);
        }

    }


}
