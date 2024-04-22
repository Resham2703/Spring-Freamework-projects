package com.jsp.hotelmanagement.exception;

public class Idnotfoundexception extends RuntimeException {

	private String message = "id not found";

	
	
	@Override
	public String getMessage() {  
		return message;
	}

	public Idnotfoundexception() { // generate constructor using super class
		super();

	}

	public Idnotfoundexception(String message) { // generate constructor using field
		super();
		this.message = message;
	}
	
	// we can handle exception using Appllicationexceptionhandler
	

}
