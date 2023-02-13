package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
     
	 @Autowired
	 StudentService sService;
	 
	  @PostMapping("/student")
	  public ResponseEntity<Student> savedStudentHandler(@RequestBody Student student) {
		  
		  Student saveStudent = sService.saveStudent(student);
		  
		  return new ResponseEntity<>(saveStudent,HttpStatus.CREATED);
		  
	  }
	  
	  @GetMapping("/student/{roll}")
	  public Student getSinglUserHandler(@PathVariable("roll") Integer roll){
		  
		 return sService.getStudent(roll);
	  }
	  
	  @GetMapping("/student")
	  public ResponseEntity<List<Student>> getAllUser(){
		  
		    List<Student> allUser = sService.getAllStudent();
		    
		    return new ResponseEntity<>(allUser,HttpStatus.OK);
		 
	  }
	  
	  @DeleteMapping("/student/{roll}")
	  public Student deleteStudentHandler(@PathVariable("roll") Integer roll){
		  
           return sService.deleteStudentByRoll(roll);
		  
	  }
	  
	  @PutMapping("/student")
	  public ResponseEntity<Student> updateStudentHandeler(@RequestBody Student student){
		  
		  Student updatedStudent = sService.updateStudent(student);
		  return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	  }
	  
	  @PutMapping("/student/{roll}")
	  public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,@RequestParam Integer marks){
		   
		  Student updatedMarks = sService.updateStudentByMarks(roll, marks);
		  return new ResponseEntity<Student>(updatedMarks,HttpStatus.ACCEPTED);
	  }
	  
	  
	  @GetMapping("/getByName/{name}")
	  public List<Student> getStudentByNameHandler (@PathVariable("name") String name){
		  
		  return sService.getStudentByName(name);
		  
	  }
	  
	  
}
