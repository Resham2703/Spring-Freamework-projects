package com.jsp.hotelmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Bookingdao;
import com.jsp.hotelmanagement.dao.Customerdao;
import com.jsp.hotelmanagement.dao.Roomdao;
import com.jsp.hotelmanagement.dto.Booking;
import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.exception.Idnotfoundexception;
import com.jsp.hotelmanagement.exception.Maxnopeopleexception;
import com.jsp.hotelmanagement.util.Responsestrcture;

@Service
public class Bookingservice {

	@Autowired
	private Bookingdao bookingdao;

	@Autowired
	private Customerdao customerdao;

	@Autowired
	private Roomdao roomdao;

	Responsestrcture<Booking> responsestrcture = new Responsestrcture<>();

	public ResponseEntity<Responsestrcture<Booking>> saveBooking(Booking booking, int rid, int cid) {
		Room room = roomdao.getRoombyid(rid);
		room.setAvilability("N");

		if (booking.getNo_people() <= room.getMax_people()) {

			Room room2 = roomdao.updateRoom(room);
			Customer customer = customerdao.getCustomerbyid(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime check_in_date = LocalDateTime.now();
			booking.setCheck_in_date(check_in_date);
			responsestrcture.setMessage("Booked Sucssesfully");
			responsestrcture.setStatus(HttpStatus.CREATED.value());
			responsestrcture.setData(bookingdao.saveBooking(booking));
			return new ResponseEntity<Responsestrcture<Booking>>(responsestrcture, HttpStatus.CREATED);

		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Booking>> updateBooking(Booking booking, int bid) {
		Booking dbbooking = bookingdao.getBookingbyId(bid);
		if (dbbooking != null) {
			if (booking.getNo_people() <= dbbooking.getRoom().getMax_people()) {
				booking.setId(bid);
				booking.setCustomer(booking.getCustomer());
				booking.setRoom(dbbooking.getRoom());
				booking.setCheck_in_date(dbbooking.getCheck_in_date());
				booking.setCheck_out_date(dbbooking.getCheck_out_date());
				responsestrcture.setMessage("Booking updated Sucssesfully");
				responsestrcture.setStatus(HttpStatus.OK.value());
				responsestrcture.setData(bookingdao.updateBooking(booking));
				return new ResponseEntity<Responsestrcture<Booking>>(responsestrcture, HttpStatus.OK);
			}
			throw new Maxnopeopleexception();
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<Responsestrcture<Booking>> deleteBooking(int bid) {
		Booking booking = bookingdao.getBookingbyId(bid);
		if (booking != null) {
			responsestrcture.setMessage("Booking Deleted Sucssesfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(bookingdao.deleteBooking(booking));

			return new ResponseEntity<Responsestrcture<Booking>>(responsestrcture, HttpStatus.OK);
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<Responsestrcture<Booking>> getBookingbyid(int bid) {
		Booking booking = bookingdao.getBookingbyId(bid);
		if (booking != null) {
			responsestrcture.setMessage("Found it ");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(booking);

			return new ResponseEntity<Responsestrcture<Booking>>(responsestrcture, HttpStatus.FOUND);
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<Responsestrcture<List<Booking>>> getAllBookings() {
		Responsestrcture<List<Booking>> responsestrcture = new Responsestrcture<>();
		if (bookingdao.getallBookings() != null) {
			responsestrcture.setMessage("Found it ");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(bookingdao.getallBookings());
			return new ResponseEntity<Responsestrcture<List<Booking>>>(responsestrcture, HttpStatus.FOUND);
		}
		throw new Idnotfoundexception();
	}

	public ResponseEntity<Responsestrcture<Booking>> closeBooking(int bid) {
		Booking booking = bookingdao.getBookingbyId(bid);
		if (booking != null) {
			LocalDateTime check_out_date = LocalDateTime.now();
			booking.setCheck_out_date(check_out_date);
			Room room = booking.getRoom();
			room.setAvilability("Y");
			booking.setRoom(room);
			responsestrcture.setMessage("Sucssesfully close booking");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(bookingdao.updateBooking(booking));
			return new ResponseEntity<Responsestrcture<Booking>>(responsestrcture,HttpStatus.OK);
		}
		throw new Idnotfoundexception();


	}
}
