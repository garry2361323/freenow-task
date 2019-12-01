package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Getter private int id;
    @Getter private String username;
}
