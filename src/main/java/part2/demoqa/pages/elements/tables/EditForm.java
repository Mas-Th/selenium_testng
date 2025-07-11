package part2.demoqa.pages.elements.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.JavascriptUtility.scrollToElementJs;

public class EditForm extends TablePage {
    private By userName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By userAge = By.id("age");
    private By userSalary = By.id("salary");
    private By userDepartment = By.id("department");
    private By btnRegister = By.id("submit");


    WebElement eUserName = driver.findElement(userName);
    WebElement eLastName = driver.findElement(lastName);
    WebElement eUserEmail = driver.findElement(userEmail);
    WebElement eUserAge = driver.findElement(userAge);
    WebElement eUserSalary = driver.findElement(userSalary);
    WebElement eUserDepartment = driver.findElement(userDepartment);



    public void inputEdit(){
        eUserSalary.clear();
        eUserSalary.sendKeys("15000");
        click(btnRegister);
        scrollToElementJs(userName);
    }



}
