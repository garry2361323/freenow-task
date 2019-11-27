package api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public abstract class User {
    public static int getUserIdByUsername(String username) {
        return given().
                queryParam("username", username).
                when().
                get("/users").
                then().
                contentType(ContentType.JSON).
                body("size()", greaterThanOrEqualTo(1)).
                extract().
                path("[0].id");
    }
}
