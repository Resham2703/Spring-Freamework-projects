package com.jsp.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Hoteldao;
import com.jsp.hotelmanagement.dao.Roomdao;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.exception.Idnotfoundexception;
import com.jsp.hotelmanagement.util.Responsestrcture;

@Service
public class Roomservice {

	@Autowired
	private Roomdao roomdao;
	@Autowired
	private Hoteldao hoteldao;

	Responsestrcture<Room> responsestrcture = new Responsestrcture<>();

	public ResponseEntity<Responsestrcture<Room>> saveRoom(Room room, int hid) {
		Responsestrcture<Room> responsestrcture = new Responsestrcture<>();
		Hotel hotel = hoteldao.getHotelbyid(hid);
		room.setHotel(hotel);
		Room room2 = roomdao.saveRoom(room);

		if (room2 != null) {
			responsestrcture.setMessage("save Successfully");
			responsestrcture.setStatus(HttpStatus.CREATED.value());
			responsestrcture.setData(room2);
			return new ResponseEntity<Responsestrcture<Room>>(responsestrcture, HttpStatus.CREATED);
		} else {
			throw new Idnotfoundexception();
		}

	}

	public ResponseEntity<Responsestrcture<Room>> updateRoom(Room room, int rid) {
		Responsestrcture<Room> responsestrcture = new Responsestrcture<>();
		Room dbRoom = roomdao.getRoombyid(rid);
		if (dbRoom != null) {
			room.setRoom_id(rid);
			room.setHotel(dbRoom.getHotel());
			responsestrcture.setMessage("update Successfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(roomdao.updateRoom(room));
			return new ResponseEntity<Responsestrcture<Room>>(responsestrcture, HttpStatus.OK);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Room>> deleteRoom(int rid) {
		Responsestrcture<Room> responsestrcture = new Responsestrcture<>();

		Room room = roomdao.getRoombyid(rid);
		if (room != null) {
			responsestrcture.setMessage("Deleted Successfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(roomdao.deleteRoom(room));
			return new ResponseEntity<Responsestrcture<Room>>(responsestrcture, HttpStatus.OK);
		} else {
			throw new Idnotfoundexception();
		}

	}

	public ResponseEntity<Responsestrcture<Room>> getRoombyid(int rid) {
		Responsestrcture<Room> responsestrcture = new Responsestrcture<>();

		Room room = roomdao.getRoombyid(rid);

		if (room != null) {
			responsestrcture.setMessage("Found Successfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(room);
			return new ResponseEntity<Responsestrcture<Room>>(responsestrcture, HttpStatus.FOUND);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<List<Room>>> getRoombytype(String room_type) {

		List<Room> rooms = roomdao.getRoombytype(room_type);

		if (rooms != null) {
			Responsestrcture<List<Room>> responsestrcture = new Responsestrcture<>();
			responsestrcture.setMessage("Found Succesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(rooms);
			return new ResponseEntity<Responsestrcture<List<Room>>>(responsestrcture, HttpStatus.FOUND);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Room>> getRoombyno(int room_no) {
		Responsestrcture<Room> responsestrcture = new Responsestrcture<>();
		Room room = roomdao.getRoombyno(room_no);
		if (room != null) {

			responsestrcture.setMessage("Found Succesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(room);
			return new ResponseEntity<Responsestrcture<Room>>(responsestrcture, HttpStatus.FOUND);

		} else {
			throw new Idnotfoundexception();
		}

	}

	public ResponseEntity<Responsestrcture<List<Room>>> getAvilability(String avilability) {
		List<Room> list = roomdao.getAvilability(avilability);
		if (list != null) {
			Responsestrcture<List<Room>> responsestrcture = new Responsestrcture<>();
			responsestrcture.setMessage("Found Succesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(list);
			return new ResponseEntity<Responsestrcture<List<Room>>>(responsestrcture, HttpStatus.FOUND);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<List<Room>>> getallRooms() {
		Responsestrcture<List<Room>> responsestrcture = new Responsestrcture<>();
		responsestrcture.setMessage("Found Sucsessfully");
		responsestrcture.setStatus(HttpStatus.FOUND.value());
		responsestrcture.setData(roomdao.getallRooms());
		return new ResponseEntity<Responsestrcture<List<Room>>>(responsestrcture, HttpStatus.FOUND);
	}


}