package com.freenow.task.api;

import com.freenow.task.models.Comment;
import com.freenow.task.models.Post;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostApi {
    public List<Post> getByUserId(int userId) {
        return given().
                queryParam("userId", userId).
                when().
                get("/posts").
                as(new TypeRef<List<Post>>() {});
    }

    public List<Comment> getCommentByPostId(int postId) {
        return given().
                get("/post/{postId}/comments", postId).
                as(new TypeRef<List<Comment>>() {});
    }
}
