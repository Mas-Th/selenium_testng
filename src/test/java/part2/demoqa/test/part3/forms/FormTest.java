package part2.demoqa.test.part3.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;


public class FormTest extends BaseTest {
    @Test
    public void testInputGender() {

        var formPage = homePage.goToFormPage().clickPracticeForms();
        // click label for input
        formPage.clickinputRadioGender();
        // check input selected
        boolean isClickInputRadio = formPage.isInputRadioGenderSelected();
        Assert.assertTrue(isClickInputRadio, "\nNot click\n");
    }

    @Test
    public void testReadHobbyCheckBoxSelected() {

        var formPage = homePage.goToFormPage().clickPracticeForms();
        // click for input
        formPage.clickCheckBoxReading();
        // check input selected
        boolean isClickReadHobbyCheckBox = formPage.isInputCheckBoxSelected();
        Assert.assertTrue(isClickReadHobbyCheckBox, "\nNot click\n");
    }

    @Test
    public void testReadHobbyCheckBoxNotSelected() {

        var formPage = homePage.goToFormPage().clickPracticeForms();
        // click for input
        formPage.clickCheckBoxReading();
        formPage.unclickCheckBoxReading();
        // check input selected
        boolean isClickReadHobbyCheckBox = formPage.isInputCheckBoxSelected();
        Assert.assertFalse(isClickReadHobbyCheckBox, "\nNot click\n");
    }
}
