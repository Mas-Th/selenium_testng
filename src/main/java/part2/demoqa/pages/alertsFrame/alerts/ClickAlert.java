package part2.demoqa.pages.alertsFrame.alerts;


import org.openqa.selenium.By;

import static utilities.JavascriptUtility.clickJS;
import static utilities.JavascriptUtility.scrollToElementJs;

public class ClickAlert extends Alert_Frame_WindowPage{
    private final By btnAlert = By.xpath("//div[@id='javascriptAlertsWrapper']//button[@id='alertButton']");
    private final By eAlertBtnAppear5 = By.xpath("//div[@id='javascriptAlertsWrapper']//button[@id='timerAlertButton']");
    private final By eAlertConfirmBtn = By.xpath("//div[@id='javascriptAlertsWrapper']//button[@id='confirmButton']");
    private final By eAlertPromptBtn = By.xpath("//div[@id='javascriptAlertsWrapper']//button[@id='promptButton']");


    public void clickBtnAlert(){
        clickJS(btnAlert);
    }

    public void clickBtnAlertAppear5Seconds(){
        clickJS(eAlertBtnAppear5);
    }

    public void clickBtnConfirm(){
        scrollToElementJs(eAlertConfirmBtn);
        clickJS(eAlertConfirmBtn);
    }

    public void clickBtnPrompt(){
        scrollToElementJs(eAlertPromptBtn);
        clickJS(eAlertPromptBtn);
    }

}
