package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    //Define all the user characters.
    // username
    private final String username;
    // password
    private final String password;
    // role
    private final String role;

    // constructor
    // for each constructor parameter, add a "@JsonProperty()" annotation to map Java object properties to JSON keys.
    // after this annotation, this class can used directly to receive a Json massages or send one.
    public User(@JsonProperty("username") String username,
                @JsonProperty("password")String password,
                @JsonProperty("role")String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getting methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }


}