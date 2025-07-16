package part2.demoqa.pages;

import org.openqa.selenium.By;

import base.BasePage;

import part2.demoqa.pages.alertsFrame.alerts.Alert_Frame_WindowPage;
import part2.demoqa.pages.elements.ElementPage;
import part2.demoqa.pages.forms.FormPage;

import static utilities.JavascriptUtility.scrollToElementJs;

public class HomePage extends BasePage {
    private final By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By elementCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private final By alertsCard = By.xpath("//div[@id='app']//h5[contains(text(), 'Alerts, Frame')]");

    private final By home = By.xpath("//title[text()='DEMOQA']");


    public FormPage goToFormPage(){

        scrollToElementJs(formsCard);
        click(formsCard);

        return new FormPage();
    }

    public ElementPage goToElementPage(){

        scrollToElementJs(elementCard);
        click(elementCard);

        return new ElementPage();
    }

    public Alert_Frame_WindowPage goToAlertFrameWindowPage(){
        scrollToElementJs(alertsCard);
        click(alertsCard);
        return new Alert_Frame_WindowPage();
    }

    public boolean isHomePageDisplayed(){
        return find(home).isDisplayed();
    }
}
