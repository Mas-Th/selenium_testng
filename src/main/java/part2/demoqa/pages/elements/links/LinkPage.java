package part2.demoqa.pages.elements.links;

import org.openqa.selenium.By;
import part2.demoqa.pages.HomePage;
import part2.demoqa.pages.elements.ElementPage;

public class LinkPage extends ElementPage {
    private By clickHome = By.id("simpleLink");
    private By clickBadRequest = By.id("bad-request");
    private By clickNotFound = By.id("invalid-url");
    private By linkResponse = By.id("linkResponse");


    public void clickHomeLink() throws InterruptedException {
        click(clickHome);
        delay(1000);
        new HomePage();

    }

    public void clickBadRequestLink(){
        click(clickBadRequest);
    }

    public void clickNotFoundLink(){
        click(clickNotFound);
    }


    public String getResponse() throws InterruptedException {
        delay(2000);
        return find(linkResponse).getText();
    }


}
