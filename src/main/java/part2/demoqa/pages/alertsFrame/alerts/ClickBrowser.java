package part2.demoqa.pages.alertsFrame.alerts;

import org.openqa.selenium.By;
import part2.demoqa.pages.HomePage;

import static utilities.JavascriptUtility.clickJS;

public class ClickBrowser extends Alert_Frame_WindowPage {
    private final By btnNewTab = By.xpath("//div[@id='browserWindows']//button[@id='tabButton']");
    private final By btnNewWindow = By.xpath("//div[@id='windowButtonWrapper']//button[@id='windowButton']");
    private final By btnNewWindowMessage = By.xpath("//div[@id='browserWindows']//button[@id='messageWindowButton']");

    public void clickBtnNewTab(){
        clickJS(btnNewTab);
    }

    public void clickBtnNewWindow(){
        clickJS(btnNewWindow);
    }

    public void clickBtnNewWindowMessage(){
        clickJS(btnNewWindowMessage);
    }
}
