package com.example.final_201930325.repository;

import com.example.final_201930325.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

    List<User> findAllByOrderByNameAsc();
}
