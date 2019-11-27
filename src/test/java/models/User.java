package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private final int id;
    private final String username;

    @JsonCreator
    User(@JsonProperty("id") int id,
         @JsonProperty("email") String email) {
        this.id = id;
        this.username = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
