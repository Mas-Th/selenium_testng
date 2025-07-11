package part2.demoqa.pages.elements;

import base.BasePage;
import org.openqa.selenium.By;
import part2.demoqa.pages.elements.links.LinkPage;
import part2.demoqa.pages.elements.tables.TablePage;

import static utilities.JavascriptUtility.clickJS;

public class ElementPage extends BasePage {
    private By table = By.xpath("//li[@id='item-3']//span[text()='Web Tables']");
    private By links = By.xpath("//li[@id='item-5']//span[text()='Links']");

    public TablePage clickTable(){
        clickJS(table);
        return new TablePage();
    }

    public LinkPage clickLinks(){
        clickJS(links);
        return new LinkPage();
    }



}
