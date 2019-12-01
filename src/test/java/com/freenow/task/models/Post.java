package com.freenow.task.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    @Getter private int id;
    @Getter private int userId;
}
