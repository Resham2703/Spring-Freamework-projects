package com.jsp.hotelmanagement.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
	private int no_people;
	private int rating;
	
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne 
	private  Room room;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(LocalDateTime check_in_date) {
		this.check_in_date = check_in_date;
	}

	public LocalDateTime getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(LocalDateTime check_out_date) {
		this.check_out_date = check_out_date;
	}

	public int getNo_people() {
		return no_people;
	}

	public void setNo_people(int no_people) {
		this.no_people = no_people;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
	
}
