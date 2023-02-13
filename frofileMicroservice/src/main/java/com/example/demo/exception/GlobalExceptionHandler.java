package com.example.demo.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<CustemizeErrorDetails> myUserNotFoundExceptionHandler(Exception e,WebRequest req) {
		CustemizeErrorDetails err=new CustemizeErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustemizeErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		System.out.println("errror");
		CustemizeErrorDetails err=new CustemizeErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustemizeErrorDetails> UnexpectedExceptionHandler(Exception e,WebRequest req) {
		CustemizeErrorDetails err=new CustemizeErrorDetails(LocalDateTime.now(),"email id exists.Plese try with new email id", req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustemizeErrorDetails> myExceptionHandler(Exception e,WebRequest req) {
		CustemizeErrorDetails err=new CustemizeErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
