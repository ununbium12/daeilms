package com.example.final_201930325.service.impl;

import com.example.final_201930325.dao.UserDAO;
import com.example.final_201930325.dto.UserResponseDto;
import com.example.final_201930325.entity.User;
import com.example.final_201930325.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userDAO.selectAllUsers();

        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : users) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setUid(user.getUid());
            userResponseDto.setPassword(user.getPassword());
            userResponseDto.setName(user.getName());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setRoles(user.getRoles());
            userResponseDtos.add(userResponseDto);
        }

        return userResponseDtos;
    }
    @Override
    public List<UserResponseDto> getAllUserOrderByName() {
        List<User> users = userDAO.selectAllUsersOrderByNameAsc();

        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : users) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setUid(user.getUid());
            userResponseDto.setPassword(user.getPassword());
            userResponseDto.setName(user.getName());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setRoles(user.getRoles());
            userResponseDtos.add(userResponseDto);
        }

        return userResponseDtos;
    }
}
