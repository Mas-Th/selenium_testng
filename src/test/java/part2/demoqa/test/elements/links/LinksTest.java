package part2.demoqa.test.elements.links;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class LinksTest extends BaseTest {

    @Test
    public void testHomeLinks() throws InterruptedException {
        var elements = homePage.goToElementPage().clickLinks();
        elements.clickHomeLink();
        boolean isHomePageDisplayed = homePage.isHomePageDisplayed();
        Assert.assertFalse(isHomePageDisplayed,"Not Displayed");
    }

    @Test
    public void testBadRequestLinks() throws InterruptedException {
        var elements = homePage.goToElementPage().clickLinks();
        elements.clickBadRequestLink();
        String actualResult =  elements.getResponse();

        Assert.assertTrue(actualResult.contains("400")&&actualResult.contains("Bad Request"), "Response not statusCode 400");

    }

    @Test
    public void testNotFoundLinks() throws InterruptedException {
        var elements = homePage.goToElementPage().clickLinks();
        elements.clickNotFoundLink();
        String actualResult =  elements.getResponse();

        Assert.assertTrue(actualResult.contains("404")&&actualResult.contains("Not Found"), "Response not statusCode 404");

    }
}
