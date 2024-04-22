package com.jsp.hotelmanagement.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.hotelmanagement.util.Responsestrcture;

@ControllerAdvice

public class Applicationexceptionhandler extends ResponseEntityExceptionHandler {

	Responsestrcture<String> responsestrcture = new Responsestrcture<>();

	@ExceptionHandler(Idnotfoundexception.class)
	public ResponseEntity<Responsestrcture<String>> idnotfoundexception(Idnotfoundexception ex) {
		responsestrcture.setMessage("id not found");
		responsestrcture.setStatus(HttpStatus.NOT_FOUND.value()); // if id not found
		responsestrcture.setData(ex.getMessage()); 
		return new ResponseEntity<Responsestrcture<String>>(responsestrcture, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestrcture<String>> nosuchelementexception(NoSuchElementException ex) {
		responsestrcture.setMessage("no element  found");
		responsestrcture.setStatus(HttpStatus.NOT_FOUND.value());
		responsestrcture.setData(ex.getMessage());
		return new ResponseEntity<Responsestrcture<String>>(responsestrcture, HttpStatus.NOT_FOUND);
	}

	// type handleMethodArgumentNotValid

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>(); // K,V pair

		for (ObjectError error : list) {
			String Fieldname = ((FieldError) error).getField();
			String Message =((FieldError)error).getDefaultMessage();
			map.put(Fieldname, Message);
		}

		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(ConstraintViolationException.class)
	public  ResponseEntity<Responsestrcture<String>>handleconstrainviolationexception(ConstraintViolationException ex){
		responsestrcture.setMessage(ex.getMessage());
		responsestrcture.setData("this field cannot be null or blank");
		responsestrcture.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Responsestrcture<String>>(responsestrcture,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Maxnopeopleexception.class)
	public ResponseEntity<Responsestrcture<String>>maxnopeopleexception(Maxnopeopleexception ex){
		responsestrcture.setMessage("max limit of people for that room");
		responsestrcture.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestrcture.setData(ex.getMessage());
		return new ResponseEntity<Responsestrcture<String>>(responsestrcture,HttpStatus.BAD_REQUEST);
	}
}
