package part2.demoqa.test.elements.javascript;



import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class JavascriptTest extends BaseTest
{

    @Test
    public void testScrollToElement() throws InterruptedException {
        homePage.goToFormPage();
    }
}
