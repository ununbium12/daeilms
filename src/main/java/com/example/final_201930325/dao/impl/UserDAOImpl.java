package com.example.final_201930325.dao.impl;

import com.example.final_201930325.dao.UserDAO;
import com.example.final_201930325.entity.User;
import com.example.final_201930325.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> selectAllUsersOrderByNameAsc() {
        return userRepository.findAllByOrderByNameAsc();
    }
}
