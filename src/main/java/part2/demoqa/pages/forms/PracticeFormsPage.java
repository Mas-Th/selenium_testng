package part2.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavascriptUtility.*;

public class PracticeFormsPage extends FormPage  {

    // method 1 using clickJS();
    private  By inputRadioGender = By.id("gender-radio-1");
    // method 2 using label for input
    //    By labelInputRender = By.xpath("//label[text()='Male']");

    private By  sportCheckBoxHobby = By.id("hobbies-checkbox-1");
    private By  readingCheckBoxHobby = By.id("hobbies-checkbox-2");
    private By  musicCheckBoxHobby = By.id("hobbies-checkbox-3");


//    private By firstName = By.id("firstName");
//    private By lastName = By.id("lastName");
//    private By userEmail = By.id("userEmail");
//
//
//
//    private By userNumber = By.id("userNumber");
//    private By userDate = By.id("dateOfBirthInput");
//    private By subjectsInput = By.id("subjectsInput");

//
//    private By uploadPicture = By.id("uploadPicture");
//    private By currentAddress = By.id("currentAddress");
//
//    private By btnSubmit = By.id("submit");


    // click gender
    public void clickinputRadioGender(){
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
