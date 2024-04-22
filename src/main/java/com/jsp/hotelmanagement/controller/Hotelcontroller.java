package com.jsp.hotelmanagement.controller;

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

import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.service.HotelService;
import com.jsp.hotelmanagement.util.Responsestrcture;

@RestController
@RequestMapping ("/saveHotel")// handle HTTP methods(GET,POST,DELETE,PUT)etc & allows URL pattern that trigerd execution of methods
public class Hotelcontroller {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Responsestrcture<Hotel>> saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	@PutMapping
	public ResponseEntity<Responsestrcture<Hotel>> updateHotel(@RequestParam int hid,@RequestBody Hotel hotel) { // RP- allows to access the value of request parameter in your controller methods
		return hotelService.updateHotel(hid, hotel);
	}

	@DeleteMapping
	public ResponseEntity<Responsestrcture<Hotel>> deleteHotel(@RequestParam int hid) {
		return hotelService.deleteHotel(hid);
	}
	@GetMapping
	public ResponseEntity<Responsestrcture<Hotel>> getHotelbyid(@RequestParam int hid) {
		return hotelService.getHotelbyid(hid);
	}
	
	
}
