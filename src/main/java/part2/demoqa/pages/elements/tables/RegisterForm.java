package part2.demoqa.pages.elements.tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterForm extends TablePage {
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


    public void inputRegister(){

        eUserName.clear();
        eUserName.sendKeys("thieu");

        eLastName.clear();
        eLastName.sendKeys("Nguyen van");

        eUserEmail.clear();
        eUserEmail.sendKeys("thieunv@gmail.com");

        eUserAge.clear();
        eUserAge.sendKeys("30");

        eUserSalary.clear();
        eUserSalary.sendKeys("10000000");

        eUserDepartment.clear();
        eUserDepartment.sendKeys("Legal");

        click(btnRegister);
    }



}
