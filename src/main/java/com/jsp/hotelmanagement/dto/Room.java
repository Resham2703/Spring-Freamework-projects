package com.jsp.hotelmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int room_id;
	private int room_no;
	private String room_type;
	private int room_price;
	private int room_bed;
	private int max_people;
	private String avilability;
	
	@Enumerated(EnumType.STRING)
	
	private Floor floor;
	
	public String getAvilability() {
		return avilability;
	}

	public void setAvilability(String avilability) {
		this.avilability = avilability;
	}

	@ManyToOne
	
	private Hotel hotel;

	
	
	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public int getRoom_bed() {
		return room_bed;
	}

	public void setRoom_bed(int room_bed) {
		this.room_bed = room_bed;
	}

	public int getMax_people() {
		return max_people;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}



	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}
