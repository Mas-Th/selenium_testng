package part3.jsonplaceholder.testapi;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {

    @BeforeSuite // Chạy một lần trước tất cả các test suite
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Có thể thêm cấu hình proxy, authentication, logging... ở đây
        // RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); // Để log tự động
    }
}