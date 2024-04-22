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

import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.service.Roomservice;
import com.jsp.hotelmanagement.util.Responsestrcture;

@RestController
@RequestMapping("/room") // API
public class Roomcontroller {

	@Autowired
	private Roomservice roomservice;

	@PostMapping
	public ResponseEntity<Responsestrcture<Room>> saveRoom(@RequestBody Room room, @RequestParam int hid) {
		return roomservice.saveRoom(room, hid);
	}

	@PutMapping
	public ResponseEntity<Responsestrcture<Room>> updateRoom(@RequestBody Room room, @RequestParam int rid) {
		return roomservice.updateRoom(room, rid);
	}

	@DeleteMapping
	public ResponseEntity<Responsestrcture<Room>> deleteRoom(@RequestParam int rid) {
		return roomservice.deleteRoom(rid);
	}

	@GetMapping
	public ResponseEntity<Responsestrcture<Room>> getRoombyid(@RequestParam int rid) {
		return roomservice.getRoombyid(rid);
	}

	@GetMapping("/roombytype") // ("/roombytype") its a API which is show's all data to given to API.
	public ResponseEntity<Responsestrcture<List<Room>>> getRoombytype(@RequestParam String room_type) {
		return roomservice.getRoombytype(room_type);
	}

	@GetMapping("/roombyno")
	public ResponseEntity<Responsestrcture<Room>> getRoombyno(@RequestParam int room_no) {
		return roomservice.getRoombyno(room_no);
	}

	@GetMapping("/roombyavilability")
	public ResponseEntity<Responsestrcture<List<Room>>> getRoombyavailability(@RequestParam String avilability) {
		return roomservice.getAvilability(avilability);
	}

	@GetMapping("/getallRooms")
	public ResponseEntity<Responsestrcture<List<Room>>> getallRooms() {
		return roomservice.getallRooms();
	}

}
