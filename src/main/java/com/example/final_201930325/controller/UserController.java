package com.example.final_201930325.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String getTest(){
        return "Get Test";
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getUserTest() {
        return "Get User Test";
    }

    @PostMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminTest(){
        return "Admin Test";
    }

}