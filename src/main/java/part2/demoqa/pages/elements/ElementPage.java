package part2.demoqa.pages.elements;

import base.BasePage;
import com.google.common.collect.Table;
import org.openqa.selenium.By;

public class ElementPage extends BasePage {
    private By table = By.xpath("//li[@id='item-3']//span[text()='Web Tables']");

    public TablePage  clickTable(){
        click(table);
        return new TablePage();
    }

}
