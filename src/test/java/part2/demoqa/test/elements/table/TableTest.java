package table;

import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class TableTest extends BaseTest {
    @Test
    public void testAddRecord(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickAddRecord().inputRegister();

    }

    @Test
    public void testEditRecord(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickEditRecord("alden@example.com").inputEdit();
    }

    @Test
    public void testDeleteRecord(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickDeleteRecord("Alden");
    }

    @Test
    public void testSearchRecord(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickSearchRecord();
    }

    @Test
    public void testBtnSearchRecord(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickBtnSearchRecord();
    }

    @Test
    public void testSelectRows(){
        var tableCard = homePage.goToElementPage().clickTable();
        tableCard.clickSelectRows();
    }


}
