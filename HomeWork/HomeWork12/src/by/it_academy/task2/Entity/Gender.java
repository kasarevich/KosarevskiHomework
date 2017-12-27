package by.it_academy.task2.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum Gender {
    @JsonProperty (value = "0")
    M,
    @JsonProperty (value = "1")
    W
}
