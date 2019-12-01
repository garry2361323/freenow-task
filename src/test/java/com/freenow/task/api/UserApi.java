package com.freenow.task.api;

import com.freenow.task.models.User;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

public class UserApi {
    public int getIdByUsername(String username) {
        List<User> users = getBy("username", username);

        // not sure if username is unique, get first matching user if there is such
        assertThat("No users found by username=" + username, users, hasSize(greaterThanOrEqualTo(1)));

        return users.get(0).getId();
    }

    private List<User> getBy(String name, String value) {
        return given().
                queryParam(name, value).
                when().
                get("/users").
                as(new TypeRef<List<User>>() {});
    }
}
