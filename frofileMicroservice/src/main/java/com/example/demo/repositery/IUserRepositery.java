package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface IUserRepositery extends JpaRepository<User, Integer>{

}
