package com.security.jwt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.entity.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
   
	Optional<UserModel> findByEmail(String email);
}
