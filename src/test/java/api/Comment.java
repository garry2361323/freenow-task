package api;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Comment {
    public List<models.Comment> getByPostId(int postId) {
        return given().
                get("/post/{postId}/comments", postId).
                as(new TypeRef<>() {});
    }
}
