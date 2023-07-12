package com.loginFlow.userLoginTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginFlow.userLoginTest.model.User;

// @RepositoryInteger
public interface UserRepository extends JpaRepository<User,Integer> {
    
    List<User> findByEmail(String email);
    List<User> findByMobile(String email);


}
