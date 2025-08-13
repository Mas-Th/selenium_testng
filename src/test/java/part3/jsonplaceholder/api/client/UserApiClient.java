package part3.jsonplaceholder.api.client;


import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private static final String USERS_ENDPOINT = "/users"; // Định nghĩa endpoint

    /**
     * Gửi yêu cầu GET để lấy thông tin của một người dùng cụ thể.
     * @param userId ID của người dùng.
     * @return Đối tượng Response từ Rest Assured.
     */
    public Response getUserById(int userId) {
        return given()
                .when()
                .get(USERS_ENDPOINT + "/" + userId);
    }

    /**
     * Gửi yêu cầu GET để lấy tất cả người dùng.
     * @return Đối tượng Response từ Rest Assured.
     */
    public Response getAllUsers() {
        return given()
                .when()
                .get();
    }

    // Có thể thêm các phương thức POST, PUT, DELETE...
}