package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repositery.IUserRepositery;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepositery uDao;

	@Override
	public User saveUser(User user) {
		return uDao.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return uDao.findAll();
	}

	@Override
	public User getUserById(Integer id) {

		return uDao.findById(id).orElseThrow(() -> new UserNotFound("User not found with id" + id));

	}

	@Override
	public User deleteUserById(Integer id) {
		User existingUser = uDao.findById(id).orElseThrow(() -> new UserNotFound("User not find by id "));

		uDao.delete(existingUser);
		return existingUser;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser= uDao.findById(user.getId()).map(usr -> {
			usr.setAddress(user.getAddress());
			usr.setFirstName(user.getLastName());
			usr.setLastName(user.getLastName());
			usr.setPhoneNumber(user.getPhoneNumber());
			return usr;
		}).orElseThrow(()->new UserNotFound("User not found with id "+user.getId()));
		
		return uDao.save(updatedUser);
	}

}
