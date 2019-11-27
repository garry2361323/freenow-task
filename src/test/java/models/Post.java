package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private final int id;
    private final int userId;

    @JsonCreator
    Post(@JsonProperty("id") int id, @JsonProperty("userId") int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}
