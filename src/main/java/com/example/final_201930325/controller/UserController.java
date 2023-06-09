package com.example.final_201930325.controller;

import com.example.final_201930325.dto.UserResponseDto;
import com.example.final_201930325.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> gerUserList() {
        List<UserResponseDto> userList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/listOrderByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> gerUserListOrderByName() {
        List<UserResponseDto> userList = userService.getAllUserOrderByName();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

}