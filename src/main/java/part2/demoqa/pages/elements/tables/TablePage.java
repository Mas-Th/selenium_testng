package part2.demoqa.pages.elements.tables;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import part2.demoqa.pages.elements.ElementPage;

import static utilities.JavascriptUtility.scrollToElementJs;

public class TablePage extends ElementPage {
    private By addRecord = By.id("addNewRecordButton");
    private By searchRecord =By.xpath("//input[@type='text' and @placeholder='Type to search' and @class='form-control' and @id='searchBox']");
    private By btnSearchRecord = By.xpath("//div[@class='input-group-append']");
    private By selectedRows = By.xpath("//span[contains(@class, 'select-wrap')]//select[@aria-label='rows per page']");

    public RegisterForm clickAddRecord(){
        click(addRecord);
        return  new RegisterForm();
    }

    public EditForm clickEditRecord(String email){
        By editRecord = By.xpath("//div[text()='"+ email +"']//following::span[@title='Edit']");
        click(editRecord);
        return new EditForm();
    }

    public void clickDeleteRecord(String user){
        By deleteRecord = By.xpath("//div[text()='"+ user +"']//following::span[@title='Delete']");
        click(deleteRecord);
        // need alert
        scrollToElementJs(deleteRecord);

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
    public void clickSelectRows(){
        Select eSelectedRows = new Select(driver.findElement(selectedRows));
        scrollToElementJs(selectedRows);
        eSelectedRows.selectByValue("10");
    }

}
