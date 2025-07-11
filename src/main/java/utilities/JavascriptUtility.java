package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptUtility extends Utility {

    /**
     * Cuộn trang (scroll) để đưa phần tử chỉ định vào trong khung nhìn (viewport) của trình duyệt.
     * <p>
     * Phương thức này sử dụng JavaScript để thực hiện cuộn đến phần tử, phù hợp trong các trường hợp:
     * - Phần tử nằm ngoài vùng hiển thị và không thể tương tác trực tiếp.
     * - Cần xử lý scroll chính xác trong các trang có nội dung động, lazy-loading, hoặc bị che khuất.
     * </p>
     *
     * @param locator Đối tượng {@link By} đại diện cho phần tử cần scroll tới.
     */
    public static void scrollToElementJs(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll element vào view
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Scroll thêm xuống 60px
        js.executeScript("window.scrollBy(0, -80);");
    }

    public static void clickJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)  driver;
        executor.executeScript("arguments[0].click()", element);
    }


}
