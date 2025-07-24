package part2.demoqa.test.alertsFrame.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

import java.time.Duration;

public class FrameTest extends BaseTest {
    @Test
    public void testFrame1(){
        var frameForm = homePage.goToAlertFrameWindowPage().clickFrame();
        String actualBigFrameText = frameForm.getTextBigFrame();
        String expectedBigFrameText = "This is a sample page";

        Assert.assertEquals(actualBigFrameText, expectedBigFrameText,"Text not equals");
    }

    @Test
    public void testFrame2(){
        var frameForm = homePage.goToAlertFrameWindowPage().clickFrame();
        String actualSmallFrameText = frameForm.getTextSmallFrame();
        String expectedSmallFrameText = "This is a sample page";

        Assert.assertEquals(actualSmallFrameText, expectedSmallFrameText,"Text not equals");


        String actualFramePageText = frameForm.getTextFramePage();
        String expectedFramePageText = "Frames";

        Assert.assertEquals(actualFramePageText, expectedFramePageText,"Text not equals");
    }

    @Test
    public void testFrame1Index(){
        var frameForm = homePage.goToAlertFrameWindowPage();
        var frameSwitch = frameForm.clickFrame();
        String actualSmallFrameText = frameSwitch.getTextSmallFrameIndex(1);
        String expectedSmallFrameText = "This is a sample page";

        Assert.assertEquals(actualSmallFrameText, expectedSmallFrameText,"Text not equals");

        String actualFramePageText = frameSwitch.getTextFramePage();
        String expectedFramePageText = "Frames";

        Assert.assertEquals(actualFramePageText, expectedFramePageText,"Text not equals");
    }

    @Test
    public void testFrame2Index(){
        var frameForm = homePage.goToAlertFrameWindowPage();
        var frameSwitch = frameForm.clickFrame();
        // [0] index start
        String actualSmallFrameText = frameSwitch.getTextSmallFrameIndex(2);
        String expectedSmallFrameText = "This is a sample page";

        Assert.assertEquals(actualSmallFrameText, expectedSmallFrameText,"Text not equals");

        String actualFramePageText = frameSwitch.getTextFramePage();
        String expectedFramePageText = "Frames";

        Assert.assertEquals(actualFramePageText, expectedFramePageText,"Text not equals");
    }

}
