package com.jsp.hotelmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Data;

@Entity
//@Data
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private  int hotel_id; 
	private String hotel_name;
	private String hotel_gst;
	private String hotel_address;
	private String hotel_manager;
	private String hotel_owner;
	private String hotel_ratting;
	
	
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_gst() {
		return hotel_gst;
	}
	public void setHotel_gst(String hotel_gst) {
		this.hotel_gst = hotel_gst;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_manager() {
		return hotel_manager;
	}
	public void setHotel_manager(String hotel_manager) {
		this.hotel_manager = hotel_manager;
	}
	public String getHotel_owner() {
		return hotel_owner;
	}
	public void setHotel_owner(String hotel_owner) {
		this.hotel_owner = hotel_owner;
	}
	public String getHotel_ratting() {
		return hotel_ratting;
	}
	public void setHotel_ratting(String hotel_ratting) {
		this.hotel_ratting = hotel_ratting;
	}
	
	
	
}
