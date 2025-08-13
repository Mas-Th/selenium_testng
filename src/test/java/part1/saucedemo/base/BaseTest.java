package part1.saucedemo.base;

import base.BasePage;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import part1.saucedemo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Map;

import static base.BasePage.delay;


public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    protected WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    @BeforeClass
    public void setup(){
        // 1. Setup ChromeDriver từ WebDriverManager
        WebDriverManager.chromedriver().setup();

        // 2. Khai báo ChromeOptions
        ChromeOptions options = new ChromeOptions();
// Vô hiệu hóa các thông báo lưu mật khẩu
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerOnboarding,EnableAutofillPasswordGeneration");
        options.addArguments("--disable-save-password-bubble");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

// Thêm các đối số này để tắt các thông báo và cảnh báo khác
        options.addArguments("--disable-popup-blocking"); // Tắt trình chặn pop-up
        options.addArguments("--disable-notifications"); // Tắt các thông báo từ trang web
        options.addArguments("--disable-infobars"); // Tắt các thanh thông tin (ví dụ: "Chrome đang được điều khiển...")
        options.addArguments("--enable-automation"); // Giúp Chrome nhận biết đang chạy ở chế độ automation

        // alert or surprise announcement
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        // 3. Khởi tạo driver với options
        driver = new ChromeDriver(options);



        //  Firefox Options
        // Khai báo FirefoxOptions
//        FirefoxOptions options = new FirefoxOptions();
//
//// Tắt các thông báo, pop-up
//        options.addPreference("dom.webnotifications.enabled", false);
//        options.addPreference("dom.push.enabled", false);
//
//// Tắt thanh thông tin (ví dụ: "Firefox đang được điều khiển...")
//        options.addArguments("-headless"); // hoặc tùy chọn khác nếu bạn muốn chạy ở chế độ ẩn
//
//// Xử lý alert bất ngờ
//        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//
//// Khởi tạo driver với options
//        WebDriver driver = new FirefoxDriver(options);


        // Edge
//        // Khai báo Edge Options
//        EdgeOptions options = new EdgeOptions();
//
//// Vô hiệu hóa các thông báo lưu mật khẩu và các thông báo khác (giống với Chrome)
//        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerOnboarding,EnableAutofillPasswordGeneration");
//        options.addArguments("--disable-save-password-bubble");
//        options.setExperimentalOption("prefs", Map.of(
//                "credentials_enable_service", false,
//                "profile.password_manager_enabled", false
//        ));
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--enable-automation");
//
//// Xử lý alert bất ngờ
//        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//
//// Khởi tạo driver với options
//        WebDriver driver = new EdgeDriver(options);


        // 4. Cấu hình timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5. Mở URL
        driver.get("https://www.saucedemo.com/");

        // 6. Khởi tạo page objects
        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();

        System.out.println("✅ Success setup");
    }


    @BeforeMethod
    public  void startTest(){

        System.out.println("Start Test Method");
    }

    @AfterMethod
    public  void endTest(){
        System.out.println("End Test Method");
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        delay(2000);
        if(driver != null){
        driver.quit();
        System.out.println("Success Close");
        }
    }
}
