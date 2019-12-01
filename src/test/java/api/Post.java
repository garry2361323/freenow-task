package api;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Post {
    public List<models.Post> getByUserId(int userId) {
        return given().
                queryParam("userId", userId).
                when().
                get("/posts").
                as(new TypeRef<>() {});
    }
}
