package part3.jsonplaceholder.testapi.users;


import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import part3.jsonplaceholder.api.client.UserApiClient;
import part3.jsonplaceholder.api.model.UserModel;
import part3.jsonplaceholder.testapi.BaseApiTest;

public class GetUserTest extends BaseApiTest { // Kế thừa để có cấu hình chung

    private final UserApiClient userApiClient = new UserApiClient(); // Khởi tạo API client

    @Test(description = "Verify user data with soft assertions for a single JSON object")
    public void testGetUserByIdWithSoftAssertions() {
        SoftAssertions softly = new SoftAssertions();

        // 1. Thực hiện cuộc gọi API thông qua client
        Response response = userApiClient.getUserById(1);

        // 2. Kiểm định Status Code (vẫn là hard assertion của Rest Assured)
        response.then().log().all() // Log toàn bộ request/response
                .statusCode(200);

        // 3. Chuyển đổi Response Body sang POJO
        // Nếu response là một mảng JSON, bạn có thể dùng .as(User[].class)
        // Trong trường hợp này là một đối tượng User duy nhất
        UserModel user = response.as(UserModel.class);

        // 4. Bắt đầu Soft Assertions trên đối tượng POJO đã parse
        softly.assertThat(user)
                .as("User object should not be null")
                .isNotNull();

        // Kiểm tra các thuộc tính cấp cao nhất
        softly.assertThat(user.getId())
                .as("Verify User ID")
                .isEqualTo(1);
        softly.assertThat(user.getName())
                .as("Verify User Name")
                .isEqualTo("Leanne Graham");
        softly.assertThat(user.getUsername())
                .as("Verify User Username")
                .isEqualTo("Bret");
        softly.assertThat(user.getEmail())
                .as("Verify User Email")
                .isEqualTo("Sincere@april.biz");
        softly.assertThat(user.getPhone())
                .as("Verify User Phone contains specific string")
                .containsIgnoringCase("x56442"); // Ví dụ dùng containsIgnoringCase
        softly.assertThat(user.getWebsite())
                .as("Verify User Website")
                .isEqualTo("hildegard.org");

        // Kiểm tra các thuộc tính lồng nhau (nested objects)
        softly.assertThat(user.getAddress())
                .as("Address object should not be null")
                .isNotNull();
        softly.assertThat(user.getAddress().getStreet())
                .as("Verify Address Street")
                .isEqualTo("Kulas Light");
        softly.assertThat(user.getAddress().getCity())
                .as("Verify Address City")
                .isEqualTo("Gwenborough");
        softly.assertThat(user.getAddress().getZipcode())
                .as("Verify Address Zipcode")
                .isEqualTo("92998-3874");

        softly.assertThat(user.getAddress().getGeo())
                .as("Geo object should not be null")
                .isNotNull();
        softly.assertThat(user.getAddress().getGeo().getLat())
                .as("Verify Geo Latitude")
                .isEqualTo("-37.3159");
        softly.assertThat(user.getAddress().getGeo().getLng())
                .as("Verify Geo Longitude")
                .isEqualTo("81.1496");

        softly.assertThat(user.getCompany())
                .as("Company object should not be null")
                .isNotNull();
        softly.assertThat(user.getCompany().getName())
                .as("Verify Company Name")
                .isEqualTo("Romaguera-Crona");

        // Kiểm tra số lượng thuộc tính cấp cao nhất của đối tượng User (nếu cần)
        // Cách đếm thuộc tính từ POJO phức tạp hơn JsonPath, thường không được khuyến khích
        // trừ khi bạn có lý do cụ thể để kiểm tra cấu trúc chính xác từ POJO.
        // Một cách thủ công là đếm getter/setter, nhưng không linh hoạt.
        // Nếu thực sự cần, có thể dùng reflection hoặc quay lại JsonPath cho phần này.
        // Ví dụ: softly.assertThat(user.getClass().getDeclaredFields().length).isEqualTo(8); // Không khuyến nghị
        // Cách tốt hơn: kiểm tra sự tồn tại của từng trường quan trọng.

        // Rất quan trọng: Thu thập tất cả các lỗi và báo cáo
        softly.assertAll();
    }
}