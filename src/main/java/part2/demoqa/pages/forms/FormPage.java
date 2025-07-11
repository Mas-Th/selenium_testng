package part2.demoqa.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import part2.demoqa.pages.HomePage;

public class FormPage extends HomePage {
    private final By practiceForms = By.xpath("//li[@id='item-0']//span[text()='Practice Form']");

    public PracticeFormsPage clickPracticeForms(){

        click(practiceForms);
        return new PracticeFormsPage();
    }












}
