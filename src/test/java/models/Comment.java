package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private Integer id;
    private Integer postId;
    private String email;

    @JsonCreator
    Comment(@JsonProperty("id") Integer id,
            @JsonProperty("postId") Integer postId,
            @JsonProperty("email") String email) {
        this.id = id;
        this.postId = postId;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getEmail() {
        return email;
    }
}
