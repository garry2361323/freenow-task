package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private final int id;
    private final int postId;
    private final String email;

    @JsonCreator
    Comment(@JsonProperty("id") int id,
            @JsonProperty("postId") int postId,
            @JsonProperty("email") String email) {
        this.id = id;
        this.postId = postId;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getEmail() {
        return email;
    }
}
