package com.jsp.hotelmanagement.exception;

public class Maxnopeopleexception extends RuntimeException {
	
	private String message  = "We Cant Have these many number of people is selected room ";
	
	@Override
	public String getMessage() {
		return message;
	}

	public Maxnopeopleexception(String message) {
		super();
		this.message = message;
	}

	public Maxnopeopleexception() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
