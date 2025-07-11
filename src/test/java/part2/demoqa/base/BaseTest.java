package part2.demoqa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import base.BasePage;
import part2.demoqa.pages.HomePage;
import utilities.JavascriptUtility;

import java.time.Duration;

import static base.BasePage.delay;

public class BaseTest {

    private WebDriver driver;

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));

        basePage = new BasePage();
        basePage.setDriver(driver);

        homePage = new HomePage();
        JavascriptUtility.setUtilityDriver();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        delay(3000);
        if(driver != null){
            driver.quit();
        }
    }
}
