package part2.demoqa.pages.alertsFrame.alerts;

import base.BasePage;
import org.openqa.selenium.By;
import part2.demoqa.pages.HomePage;


import static utilities.JavascriptUtility.clickJS;

public class Alert_Frame_WindowPage extends HomePage {
    private final By eAlert = By.xpath("//li[@id='item-1']//span[contains(text(), 'Alerts')]");
    private final By eBrowser = By.xpath("//li[@id='item-0']//span[contains(text(), 'Browser Windows')]");
    private final By eFrame = By.xpath("//li[@id='item-2']//span[contains(text(), 'Frames')]");
    private final By eModalDialog = By.xpath("//li[@id='item-4']//span[contains(text(), 'Modal')]");


    public ClickAlert clickAlert(){
        clickJS(eAlert);
        return new ClickAlert();
    }

    public ClickBrowser clickBrowser(){
        clickJS(eBrowser);
        return new ClickBrowser();
    }

    public ClickFrame clickFrame(){
        clickJS(eFrame);
        return new ClickFrame();
    }

    public ClickModalDialog clickModalDialog(){
        clickJS(eModalDialog);
        return new ClickModalDialog();
    }

}

