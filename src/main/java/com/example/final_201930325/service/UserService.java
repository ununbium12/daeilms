package com.example.final_201930325.service;

import com.example.final_201930325.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers();
    List<UserResponseDto> getAllUserOrderByName();
}
