package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;


@RestController
@RequestMapping("/api/v1/")
public class UserController {
    
	@Autowired
	UserServiceImpl userOpe;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUserHandler(){
		
		List<User> userList = userOpe.getAllUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	
	@PostMapping("/addUser")
	public ResponseEntity<User> saveUserHandler(@Valid @RequestBody User user) {
		User savedUser =userOpe.saveUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("id") Integer id){
		
		User getUserById = userOpe.getUserById(id);
		return new ResponseEntity<>(getUserById,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUserByIdHandler(@PathVariable("id") Integer id){
		
		User deletedUser = userOpe.deleteUserById(id);
		return new ResponseEntity<>(deletedUser,HttpStatus.OK);
	}
	@PutMapping("/user")
	public ResponseEntity<User> updateUserByIdHandler(@RequestBody User user){
		
		User updatedUser = userOpe.updateUser(user);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
}
