package com.jsp.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hotelmanagement.dto.Booking;
import com.jsp.hotelmanagement.service.Bookingservice;
import com.jsp.hotelmanagement.util.Responsestrcture;

@RestController
@RequestMapping("/booking")
public class Bookinngcontroller {

	@Autowired
	private Bookingservice bookingservice;

	@PostMapping
	public ResponseEntity<Responsestrcture<Booking>> saveBooking(@RequestBody Booking booking, @RequestParam int cid, @RequestParam int rid) {
		return bookingservice.saveBooking(booking, cid, rid);
	}

	@PutMapping
	public ResponseEntity<Responsestrcture<Booking>> updateBooking(@RequestBody Booking booking, @RequestParam int bid) {
		return bookingservice.updateBooking(booking, bid);

	}

	@DeleteMapping
	public ResponseEntity<Responsestrcture<Booking>> deleteBooking(@RequestParam int bid) {
		return bookingservice.deleteBooking(bid);
	}

	@GetMapping("/getBookingbyid")
	public ResponseEntity<Responsestrcture<Booking>> getBookingbyid(@RequestParam int bid) {
		return bookingservice.deleteBooking(bid);
	}

	@GetMapping("/getAllBookings")
	public ResponseEntity<Responsestrcture<List<Booking>>> getAllBookings() {
		return bookingservice.getAllBookings();
	}

	@PutMapping("/closeBooking")
	public ResponseEntity<Responsestrcture<Booking>> closeBooking(@RequestParam int bid) {
		return bookingservice.closeBooking(bid);
	}
}
