package part2.demoqa.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.JavascriptUtility.*;

public class PracticeFormsPage extends FormPage  {

    // method 1 using clickJS();
    public  By inputRadioGender = By.id("gender-radio-1");
    // method 2 using label for input
    //    By labelInputRender = By.xpath("//label[text()='Male']");

    public By  sportCheckBoxHobby = By.id("hobbies-checkbox-1");
    public By  readingCheckBoxHobby = By.id("hobbies-checkbox-2");
    public By  musicCheckBoxHobby = By.id("hobbies-checkbox-3");

    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By userEmail = By.id("userEmail");

    public By userNumber = By.id("userNumber");
    public By userDate = By.id("dateOfBirthInput");
    public By subjectsInput = By.id("subjectsInput");

    public By uploadPicture = By.id("uploadPicture");
    public By currentAddress = By.id("currentAddress");

    public By clickDropdown1 = By.xpath("//form[@id='userForm']//div[@id='city']");
    public By clickDropdown2 = By.xpath("//form[@id='userForm']//div[@id='state']");

    public By dropdownText1 = By.id("react-select-3-input");
    public By dropdownText2 = By.id("react-select-4-input");



    public By btnSubmit = By.id("submit");


    WebElement eFirstName = find(firstName);
    WebElement eLastName = find(lastName);
    WebElement eUserEmail = find(userEmail);
    WebElement eUserNumber = find(userNumber);
    WebElement eCurrentAddress = find(currentAddress);
    WebElement eUserDate = find(userDate);
    WebElement eUploadPicture = find(uploadPicture);
    WebElement eSubjectsInput = find(subjectsInput);


    // click btn submit
    public void clickBtnSubmit(){
        scrollToElementJs(btnSubmit);
        clickJS(btnSubmit);
    }


    // click select input
    public void clickInputPracticeForm(){
        clickJS(inputRadioGender);
        clickJS(inputRadioGender);
        clickJS(readingCheckBoxHobby);
        clickJS(musicCheckBoxHobby);
        clickJS(userDate);
        clickJS(clickDropdown1);
        clickJS(clickDropdown2);

    }

    // click gender
    public void clickInputRadioGender(){
        scrollToElementJs(inputRadioGender);
        clickJS(inputRadioGender);
    }

    // click checkbox sport
    public void clickCheckBoxSport(){
        if(!find(sportCheckBoxHobby).isSelected()){
        scrollToElementJs(sportCheckBoxHobby);
        clickJS(sportCheckBoxHobby);
        }
    }

    // click checkbox read
    public void clickCheckBoxReading(){
        if(!find(readingCheckBoxHobby).isSelected()){
            scrollToElementJs(readingCheckBoxHobby);
            clickJS(readingCheckBoxHobby);
        }
    }
    // click checkbox music
    public void clickCheckBoxMusic(){
        if(!find(musicCheckBoxHobby).isSelected()){
            scrollToElementJs(musicCheckBoxHobby);
            clickJS(musicCheckBoxHobby);
        }
    }

    // unclick checkbox read  click x2
    public void unclickCheckBoxReading(){
        if(find(readingCheckBoxHobby).isSelected()){
            scrollToElementJs(readingCheckBoxHobby);
            clickJS(readingCheckBoxHobby);
        }
    }


    public boolean isInputCheckBoxSelected(){
        return find(readingCheckBoxHobby).isSelected();
    }




    // check input selected
    public boolean isInputRadioGenderSelected(){
        return find(inputRadioGender).isSelected();

    }

}
