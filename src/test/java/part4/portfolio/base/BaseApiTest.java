package part4.portfolio.base;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ProxySpecification;
import org.testng.annotations.BeforeSuite;



public class BaseApiTest {

    @BeforeSuite // Chạy một lần trước tất cả các test suite
    public void setup() {
        // URI
        RestAssured.baseURI = "https://myportfolio-4u07.onrender.com";
        
        //  log 
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        
        // Proxy
        // RestAssured.proxy("your.proxy.host", 8888);
        // Nếu proxy yêu cầu xác thực:
        // Cấu hình Proxy CÓ xác thực
//        String proxyHost = "your.proxy.host"; // Thay thế bằng host proxy thực tế của bạn
//        int proxyPort = 8888;                  // Thay thế bằng port proxy thực tế của bạn
//        String proxyUsername = "your_proxy_username"; // Thay thế bằng username của proxy
//        String proxyPassword = "your_proxy_password"; // Thay thế bằng password của proxy

//        RestAssured.proxy(new ProxySpecification(proxyHost, proxyPort, "https") // Khởi tạo ProxySpecification
////                .withAuth(proxyUsername, proxyPassword)); // Thêm xác thực
//          .withAuth(proxyUsername, proxyPassword));

        // Nếu proxy của bạn chỉ cần host và port (không cần xác thực) thì dùng:
        // RestAssured.proxy(proxyHost, proxyPort);

        // 4. Cấu hình Authentication (Tùy chọn, nếu API yêu cầu xác thực)
        // A. Basic Authentication (Preemptive - gửi thông tin đăng nhập ngay lập tức)
        // RestAssured.authentication = RestAssured.preemptive().basic("your_username", "your_password");



        // C. Digest Authentication (Nếu API yêu cầu)
//         RestAssured.authentication = RestAssured.digest("your_username", "your_password");

        // D. Form Authentication (Cho các trang web có form login)
//         RestAssured.authentication = RestAssured.form("your_username", "your_password");

        // 5. Cấu hình Timeout (Tùy chọn, để ngăn chặn test chạy quá lâu)
        // Thiết lập timeout kết nối và socket cho Http Client của Rest Assured
        // 5000ms = 5 giây cho kết nối, 10000ms = 10 giây cho socket (thời gian chờ dữ liệu)
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000)
                        .setParam("http.socket.timeout", 10000));

        // 6. Cấu hình Default Headers (Tùy chọn, cho các header chung)
        // Ví dụ: Content-Type mặc định là JSON cho tất cả các request
        // Đặt header Content-Type
        // Đặt header Accept

        // B. OAuth2/Bearer Token Authentication (Thêm token vào Header)
//        String accessToken = "YOUR_OAUTH2_BEARER_TOKEN"; // Lấy từ biến môi trường hoặc file cấu hình
//
//        RestAssured.requestSpecification = RestAssured.given()
//                .header("Authorization", "Bearer " + accessToken)
//                .header("Content-Type", "application/json") // Đặt header Content-Type
//                .header("Accept", "application/json")
//                .header("X-Custom-Header", "MyCustomValue");      // Đặt header Accept


        // 7. Cấu hình Truststore/Keystore (Tùy chọn, cho chứng chỉ SSL tự ký hoặc tùy chỉnh)
        // Nếu bạn gặp lỗi SSL handshake, có thể cần cấu hình này
//         RestAssured.useRelaxedHTTPSValidation(); // KHÔNG KHUYẾN NGHỊ TRONG MÔI TRƯỜNG PROD! Chỉ dùng cho DEV/TEST.
//         RestAssured.config = RestAssuredConfig.config().sslConfig(
//             new SSLConfig().keyStore("/path/to/your/keystore.jks", "keystore_password")
//                            .trustStore("/path/to/your/truststore.jks", "truststore_password")
//         );

        System.out.println("Rest Assured global setup complete.");
        
        

    }
}