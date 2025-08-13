package part4.portfolio.user;


import org.testng.annotations.Test;
import part4.portfolio.base.BaseApiTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class GetUserTest extends BaseApiTest {

    @Test(description = "Check resume successfully")
    public void testGetResume() {
        given()
                .when()
                .get("")
                .then().
                log().all()
                .statusCode(200);
    }


    @Test(description = "Check api/users successfully")
    public void testGetResumeUser() {
        given()
                .when()
                .get("/api/users")
                .then().
                log().all()
                .statusCode(200)
                .body(equalTo("users"))
                ;
    }

    @Test(description = "Check api/users successfully")
    public void testGetResumeCreateUser() {
        CreateUser request = new CreateUser("john", "passpass");

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/api/users")
                .then().
                log().all()
                .statusCode(200)
                .body(equalTo(" ok create user"))
        ;
    }

    @Test(description = "Check api/games successfully")
    public void testGetResumeGame() {
        given()
                .when()
                .get("/api/games")
                .then().
                log().all()
                .statusCode(200)
                .body(equalTo("game"))
        ;
    }





}
