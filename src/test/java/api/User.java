package api;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

public class User {
    public int getIdByUsername(String username) {
        var users = getBy("username", username);

        // not sure if username is unique, get first matching user if there is such
        assertThat("No users found by username=" + username, users, hasSize(greaterThanOrEqualTo(1)));

        return users.get(0).getId();
    }

    private List<models.User> getBy(String name, String value) {
        return given().
                queryParam(name, value).
                when().
                get("/users").
                as(new TypeRef<>() {});
    }
}
