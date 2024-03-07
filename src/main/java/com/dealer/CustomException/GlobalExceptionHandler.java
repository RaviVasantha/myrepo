package com.dealer.CustomException;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {
	@ExceptionHandler(value=NameNotFoundException.class)
	public ResponseEntity<Object> noName(NameNotFoundException mm) {
		return new ResponseEntity <>(mm.getMessage(),HttpStatus.NOT_FOUND);		
	}
	@ExceptionHandler(value=ProductNotFoundException.class)
		public ResponseEntity<Object> noProduct(ProductNotFoundException nn) {
		return new ResponseEntity<>(nn.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	@ExceptionHandler(value=NullPointerException.class)
		public ResponseEntity<Object> nullfind(NullPointerException ff) {
			return new ResponseEntity<>(ff.getMessage(),HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(value=NumberFormatException.class)
	public ResponseEntity<Object> incorrectformat(NumberFormatException ff) {
		return new ResponseEntity<>("kannu therilaaya",HttpStatus.NOT_FOUND);
	}
	
	}
	
	




