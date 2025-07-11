package part2.demoqa.test.part3.table;

import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class TableTest extends BaseTest {
    @Test
    public void testAddRecord(){
        var tableCard = homePage.goToElemetPage().clickTable();
        tableCard.clickAddRecord().inputRegister();

    }

    @Test
    public void testEditRecord(){
        var tableCard = homePage.goToElemetPage().clickTable();
        tableCard.clickEditRecord();
    }

    @Test
    public void testDeleteRecord(){
        var tableCard = homePage.goToElemetPage().clickTable();
        tableCard.clickDeleteRecord();
    }

    @Test
    public void testSearchRecord(){
        var tableCard = homePage.goToElemetPage().clickTable();
        tableCard.clickSearchRecord();
    }

    @Test
    public void testBtnSearchRecord(){
        var tableCard = homePage.goToElemetPage().clickTable();
        tableCard.clickBtnSearchRecord();
    }




}
