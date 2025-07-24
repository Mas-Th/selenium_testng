package forms;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

import java.time.Duration;



public class FormTest extends BaseTest {


    @Test
    public void testInputGender() {

        var formPage = homePage.goToFormPage().clickPracticeForms();
        // click label for input
        formPage.clickInputRadioGender();
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

    @Test
    public void testPracticeForm() {

        var practiceFormsPage = homePage.goToFormPage().clickPracticeForms();

        WebElement eFirstName = driver.findElement(practiceFormsPage.firstName);
        WebElement eLastName = driver.findElement(practiceFormsPage.lastName);
        WebElement eUserEmail = driver.findElement(practiceFormsPage.userEmail);
        WebElement eUserNumber = driver.findElement(practiceFormsPage.userNumber);
        WebElement eCurrentAddress = driver.findElement(practiceFormsPage.currentAddress);
        WebElement eUserDate = driver.findElement(practiceFormsPage.userDate);
        WebElement eUploadPicture = driver.findElement(practiceFormsPage.uploadPicture);
        WebElement eSubjectsInput = driver.findElement(practiceFormsPage.subjectsInput);

        // click for input
        practiceFormsPage.clickInputPracticeForm();

        WebDriverWait waitS = new WebDriverWait(driver, Duration.ofSeconds(1));

        // Nếu field bị readonly
        // ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('readonly')", eUserDate);

        eFirstName.clear();
        eFirstName.sendKeys("thieu");

        eLastName.clear();
        eLastName.sendKeys("nguyen van");

        eUserEmail.clear();
        eUserEmail.sendKeys("thieunv@gmail.com");

        eUserNumber.clear();
        eUserNumber.sendKeys("1234564534534");

        eCurrentAddress.clear();
        eCurrentAddress.sendKeys("yen dinh thanh hoa");

        eSubjectsInput.clear();
        eSubjectsInput.sendKeys("English");
        eSubjectsInput.sendKeys(Keys.ENTER);

        eSubjectsInput.sendKeys("Math");
        eSubjectsInput.sendKeys(Keys.ENTER);

        eSubjectsInput.sendKeys("Chemistry");
        eSubjectsInput.sendKeys(Keys.ENTER);

        eUploadPicture.clear();
        eUploadPicture.sendKeys("D:\\Picture\\myPicture.jpg");

        eUserDate.clear();
        eUserDate.sendKeys("01-12-1996");

        WebElement dropdownInput1 = driver.findElement(practiceFormsPage.dropdownText1);
        dropdownInput1.sendKeys("Rajasthan");
        dropdownInput1.sendKeys(Keys.ENTER);

        WebElement dropdownInput2 = driver.findElement(practiceFormsPage.dropdownText2);
        dropdownInput2.sendKeys("Jaipur");
        dropdownInput2.sendKeys(Keys.ENTER);

        practiceFormsPage.clickBtnSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='dialog'][aria-modal='true'][class*='fade']")));

        Assert.assertTrue(dialog.isDisplayed(), "\nNot click\n");
    }
}
