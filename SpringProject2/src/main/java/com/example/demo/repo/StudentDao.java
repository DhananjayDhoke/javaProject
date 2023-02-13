package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
     
	 public  List<Student> findByName(String name);
}
