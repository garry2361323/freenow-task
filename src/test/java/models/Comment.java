package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @Getter private int id;
    @Getter private int postId;
    @Getter private String email;
}
