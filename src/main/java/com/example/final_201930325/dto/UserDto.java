package com.example.final_201930325.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private String uid;
    private String password;
    private String name;
    private String email;
    private List<String> roles = new ArrayList<>();

    public UserDto(String uid, String password, String name, String email, List<String> roles) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
