package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.repo.Roomrepo;

@Repository
public class Roomdao {

	@Autowired
	private Roomrepo roomrepo;

	public Room saveRoom(Room room) {
		return roomrepo.save(room);
	}

	public Room updateRoom(Room room) {
		return roomrepo.save(room);
	}

	public Room deleteRoom(Room room) {
		roomrepo.delete(room);
		return room;
	}

	public Room getRoombyid(int rid) {

		if (roomrepo.getRoombyid(rid) != null) {
			return roomrepo.getRoombyid(rid);
		}
		return null;

	}

	public List<Room> getallRooms() {
		return roomrepo.findAll();
	}

	public List<Room> getRoombytype(String room_type) {
		if (roomrepo.getRoombytype(room_type) != null) {
			return roomrepo.getRoombytype(room_type);
		}
		return null;
	}

	public Room getRoombyno(int room_no) {
		if (roomrepo.getRoombyno(room_no) != null) {
			return roomrepo.getRoombyno(room_no);
		}
		return null;
	}

	public List<Room> getAvilability(String availability) {
		if (roomrepo.getAvilability(availability) != null) {
			return roomrepo.getAvilability(availability);
		}
		return null;
	}

}
