package part2.demoqa.base;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import part2.demoqa.pages.HomePage;
import part2.demoqa.utility.TakeScreenshot;
import utilities.JavascriptUtility;

import java.io.File;

import java.time.Duration;

import static base.BasePage.delay;


public class BaseTest {

    protected WebDriver driver;

    protected BasePage basePage;
    protected HomePage homePage;

    String URL = "https://demoqa.com";

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        // element exists in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));

        basePage = new BasePage();
        basePage.setDriver(driver);

        homePage = new HomePage();
        JavascriptUtility.setUtilityDriver();
    }

    @AfterMethod
    public  void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            // screenshot test failed
            File destination = TakeScreenshot.testFailed(testResult.getName());
            System.out.println("Screenshot:" + destination);
        }

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        boolean isDebug = Boolean.parseBoolean(System.getProperty("debug", "false"));
        if (isDebug) delay(3000);

        if (driver != null) {
            // Close all opened windows/tabs before quitting
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                driver.close();
            }
            driver.quit();
        }
    }
}
