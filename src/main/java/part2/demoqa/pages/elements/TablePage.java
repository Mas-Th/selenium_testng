package part2.demoqa.pages.elements;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TablePage extends BasePage {
    private By addRecord = By.id("addNewRecordButton");
    private By editRecord = By.id("edit-record-1");
    private By deleteRecord = By.id("delete-record-1");
    private By searchRecord =By.xpath("//input[@type='text' and @placeholder='Type to search' and @class='form-control' and @id='searchBox']");
    private By btnSearchRecord = By.xpath("//div[@class='input-group-append']");

    public RegisterForm clickAddRecord(){
        click(addRecord);
        return  new RegisterForm();
    }

    public void clickEditRecord(){
        click(editRecord);
    }

    public void clickDeleteRecord(){
        click(deleteRecord);
    }

    public void clickSearchRecord(){
        click(searchRecord);
        WebElement input = driver.findElement(searchRecord);
        input.clear();
        input.sendKeys("ci");
    }

    public void clickBtnSearchRecord(){
        WebElement input = driver.findElement(searchRecord);
        input.clear();
        input.sendKeys("ci");
        click(btnSearchRecord);

    }

}
