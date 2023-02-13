package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentDao;
import com.example.demo.service.StudentService;

@Service
public class StudentImpl implements StudentService{
     
	@Autowired
	StudentDao sDao;
	
	@Override
	public Student saveStudent(Student student) {
		
		return sDao.save(student);
		
	}

	@Override
	public Student getStudent(Integer roll)throws StudentException {
//	   Optional<Student> opt=sDao.findById(roll);
//	   
//	   if(opt.isPresent()) {
//		  
//		   Student student = opt.get();
//		   return student;
//	   }
//	   else {
//		   throw new StudentException("Student not exist with id :"+roll);
//	   }
//	   
//	}
		
	  return   sDao.findById(roll).orElseThrow(()->new StudentException("Student not found with id :"+roll));
	
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sDao.findAll();
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		
		Student getExistingStudent = sDao.findById(roll).orElseThrow(()-> new StudentException("User not exist"));
		
		 sDao.delete(getExistingStudent);
		 
		 return getExistingStudent;
		
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		   Optional<Student> opt=sDao.findById(student.getRoll());
		   
		   if(opt.isPresent()) {
			   
			   //Student existingStudent = opt.get();
			   
			   return sDao.save(student);
		   }
		   else {
			   
			   throw new StudentException("Student not exist");
		   }
	}

	@Override
	public Student updateStudentByMarks(Integer roll, Integer marks) throws StudentException {
		  Optional<Student> opt=sDao.findById(roll);
		  
		  if(opt.isPresent()) {
			  
			  Student existingStudent = opt.get();
			  
			  existingStudent.setMarks(existingStudent.getMarks()+marks);
			  
			 return sDao.save(existingStudent);
		  }
		  else {
			 throw new  StudentException("Student not exist");
		  }
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentException {
		   
		  List<Student> student= sDao.findByName(name);
		  
		  if(!student.isEmpty()) {
			  return student;
		  }
		  else {
			  throw new StudentException("Student not found with name");
		  }
		  
	}
	
}
