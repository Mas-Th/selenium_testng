package part2.demoqa.test.alertsFrame.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class ModalDialogTest extends BaseTest {
    @Test
    public  void testSmallModal(){

        var modalPage = homePage.goToAlertFrameWindowPage();
        var modalDialogPAge = modalPage.clickModalDialog();
        modalDialogPAge.clickSmallModal();
        String smallModalText = modalDialogPAge.smallModalText();


        Assert.assertTrue(smallModalText.contains("This is a small modal."), "Not contain text");

        modalDialogPAge.closeSmallModal();

    }

    @Test
    public  void testLargeModal(){

        var modalPage = homePage.goToAlertFrameWindowPage();
        var modalDialogPAge = modalPage.clickModalDialog();
        modalDialogPAge.clickLargeModal();
        String largeModalText = modalDialogPAge.largeModalText();


        Assert.assertTrue(largeModalText.contains("This is a large modal."), "Not contain text");

        modalDialogPAge.closeLargeModal();

    }

}
