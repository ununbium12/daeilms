package com.example.final_201930325.dao;

import com.example.final_201930325.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> selectAllUsers();
    List<User> selectAllUsersOrderByNameAsc();
}
