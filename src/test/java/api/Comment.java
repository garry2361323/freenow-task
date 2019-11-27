package api;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class Comment {
    public static List<models.Comment> getByPostId(int postId) {
        return given().
                get("/post/{postId}/comments", postId).
                as(new TypeRef<List<models.Comment>>() {});
    }
}
