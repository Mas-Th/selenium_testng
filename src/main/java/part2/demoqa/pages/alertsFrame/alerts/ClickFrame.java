package part2.demoqa.pages.alertsFrame.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.JavascriptUtility.scrollToElementJs;
import static utilities.SwitchToUtility.*;


public class ClickFrame extends Alert_Frame_WindowPage{
    private final By eTextFrame = By.id("sampleHeading");
    private final By eTextFramePage = By.xpath("//div[@id='framesWrapper']//h1[contains(text(), 'Frames')]");
    private final String frame1 = "frame1";
    private final String frame2 = "frame2";

    public String getTextFramePage(){
        switchToDefaultContent();
        return find(eTextFramePage).getText();
    }

    public String getTextBigFrame(){
        switchToFrameString(frame1);
        return find(eTextFrame).getText();
    }

    public String getTextSmallFrame(){
        switchToFrameString(frame2);
        return find(eTextFrame).getText();
    }


    public String getTextSmallFrameIndex(int index){
        switchToFrameIndex(index);
        scrollToElementJs(eTextFrame);
        return find(eTextFrame).getText();
    }
}
