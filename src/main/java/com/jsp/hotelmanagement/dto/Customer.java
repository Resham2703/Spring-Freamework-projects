package com.jsp.hotelmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int c_id;
	private String c_name;
	private String c_address;
	private String c_email;
	private String c_password;
	private long c_phone;
	private String c_aadhar;
	
	
	 
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public long getC_phone() {
		return c_phone;
	}
	public void setC_phone(long c_phone) {
		this.c_phone = c_phone;
	}
	public String getC_aadhar() {
		return c_aadhar;
	}
	public void setC_aadhar(String c_aadhar) {
		this.c_aadhar = c_aadhar;
	}
	
	
	
	
	
}
