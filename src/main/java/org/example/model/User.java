package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("address")
    String address;

    /*public User(int id, String name, String address) {
        this.address = address;
        this.id= id;
        this.name = name;
    }*/
}
