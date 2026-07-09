package api;

import io.restassured.RestAssured;

public class UserApi {
    public void deleteUser(String token){

        RestAssured
                .given()
                .header("Authorization", token)

                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")

                .then()
                .statusCode(202);
    }
}
