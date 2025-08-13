package part1.saucedemo.pages;

import org.openqa.selenium.By;
import base.BasePage;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton= By.id("login-button");


    private final By errorMessage= By.xpath("//div[@id='login_button_container']//h3");


    public void setUsername(String username){
        setText(usernameField, username);
    }

    public void setPassword(String password) {

        setText(passwordField, password);
    }


    public ProductPage loginToApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        click(loginButton);
        return new ProductPage();
    }



    public String getErrorMessage(){
        return find(errorMessage).getText();
    }


}
