package com.example.demo.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustemizeErrorDetails {
   
	private LocalDateTime timeStamp;
	private String message;
	private String details;
	
}
