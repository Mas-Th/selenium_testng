package part2.demoqa.test.elements.checkboxes;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;


public class CheckboxTest extends BaseTest {
    @Test
    public void testCheckbox(){

    var formPage = homePage.goToFormPage().clickPracticeForms();
    formPage.clickCheckBoxReading();
    formPage.clickCheckBoxMusic();
    formPage.clickCheckBoxSport();
    formPage.unclickCheckBoxReading();

    boolean isSelectedReadCheckbox = formPage.isInputCheckBoxSelected();

        Assert.assertTrue(!isSelectedReadCheckbox, "Checkbox read is Selected");

    }
}
