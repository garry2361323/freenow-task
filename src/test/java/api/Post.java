package api;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class Post {
    public static List<models.Post> getByUserId(int userId) {
        return given().
                queryParam("userId", userId).
                when().
                get("/posts").
                as(new TypeRef<List<models.Post>>() {});
    }
}
