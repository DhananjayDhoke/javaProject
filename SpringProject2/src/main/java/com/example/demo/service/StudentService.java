package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.StudentException;
import com.example.demo.model.Student;

public interface StudentService {
    
	public Student saveStudent (Student student);
	public Student getStudent (Integer roll) throws StudentException;
	public List<Student> getAllStudent();
	public Student  deleteStudentByRoll(Integer roll) throws StudentException;
	public Student  updateStudent(Student student) throws StudentException;
	public Student  updateStudentByMarks(Integer roll, Integer marks) throws StudentException;
	public List<Student> getStudentByName(String name) throws StudentException;
}