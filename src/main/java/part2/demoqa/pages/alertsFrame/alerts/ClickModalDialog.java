package part2.demoqa.pages.alertsFrame.alerts;

import org.openqa.selenium.By;

import static utilities.JavascriptUtility.clickJS;
import static utilities.JavascriptUtility.scrollToElementJs;

public class ClickModalDialog extends Alert_Frame_WindowPage{
    private final By btnSmallModal = By.id("showSmallModal");
    private final By smallModalText = By.xpath("//div[contains(text(), 'This is a small modal')]");
    private final By closeSmallModal =By.id("closeSmallModal");

    private final By btnLargeModal = By.id("showLargeModal");
    private final By largeModalText = By.xpath("//div[contains(text(), 'This is a small modal')]");
    private final By closeLargeModal = By.id("closeLargeModal");

    public void clickSmallModal(){
        scrollToElementJs(btnSmallModal);
        clickJS(btnSmallModal);
    }

    public String smallModalText(){
        return find(smallModalText).getText();
    }

    public void closeSmallModal(){
        clickJS(closeSmallModal);
    }

    public void clickLargeModal(){
        scrollToElementJs(btnLargeModal);
        clickJS(btnLargeModal);
    }

    public String largeModalText(){
        return find(largeModalText).getText();
    }

    public void closeLargeModal(){
        clickJS(closeLargeModal);
    }
}
