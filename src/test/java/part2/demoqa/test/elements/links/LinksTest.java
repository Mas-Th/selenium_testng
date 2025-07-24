package links;

import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.demoqa.base.BaseTest;

public class LinksTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LinksTest.class);

    @Epic("Trang chính")
    @Feature("Links")
    @Story("Kiểm tra link Home")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kiểm tra link Home có hiển thị trang chủ không")

    @Test
    public void testHomeLinks() {
        log.info("Start Test: testHomeLinks");

        Allure.step("Đi tới trang Elements và click vào Links", () -> {
            var elements = homePage.goToElementPage().clickLinks();
            Allure.step("Click vào Home Link", elements::clickHomeLink);
        });

        Allure.step("Xác minh trang chủ không hiển thị", () -> {
            boolean isHomePageDisplayed = homePage.isHomePageDisplayed();
            Assert.assertFalse(isHomePageDisplayed, "Home page vẫn hiển thị");
        });


        log.info("End Test: testHomeLinks");
    }

    @Epic("Trang chính")
    @Feature("Links")
    @Story("Kiểm tra link bad request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kiểm tra link có hiển thị trang khac không")

    @Test
    public void testBadRequestLinks() throws InterruptedException {
        Allure.step("den trang home", ()->{
            var elements = homePage.goToElementPage().clickLinks();
            elements.clickBadRequestLink();

            Allure.step("Verify", ()->{
                String actualResult =  elements.getResponse();
                Assert.assertTrue(actualResult.contains("400")&&actualResult.contains("Bad Request"), "Response not statusCode 400");
            });
        });
    }

    @Epic("Trang chính")
    @Feature("Links")
    @Story("Kiểm tra link not found")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kiểm tra link có hiển thị trang khac không")
    @Test
    public void testNotFoundLinks() throws InterruptedException {
        Allure.step("Den trang chu va xac minh", ()->{
            var elements = homePage.goToElementPage().clickLinks();
            elements.clickNotFoundLink();
            String actualResult =  elements.getResponse();
            Assert.assertTrue(actualResult.contains("404")&&actualResult.contains("Not Found"), "Response not statusCode 404");
        });

    }
}
