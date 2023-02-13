package com.example.demo.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.demo.model.User;





@Validated
public interface IUserService {
    public User saveUser(User user);
    public List<User> getAllUser();
    public User getUserById(Integer id);
    public User deleteUserById(Integer id);
    public User updateUser(User user);
    
}
