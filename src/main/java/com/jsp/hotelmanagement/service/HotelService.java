package com.jsp.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Hoteldao;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.exception.Idnotfoundexception;
import com.jsp.hotelmanagement.util.Responsestrcture;

@Service
public class HotelService {

	@Autowired
	private Hoteldao hoteldao;
	
	public  ResponseEntity<Responsestrcture<Hotel>> saveHotel(Hotel hotel) {
		Responsestrcture<Hotel>responsestrcture= new Responsestrcture<>();
		responsestrcture.setMessage("Save Data");
		responsestrcture.setStatus(HttpStatus.CREATED.value());
		responsestrcture.setData(hoteldao.saveHotel(hotel));
		return new ResponseEntity<Responsestrcture<Hotel>>(responsestrcture,HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestrcture<Hotel>> updateHotel(int hid,Hotel hotel) {
		Responsestrcture<Hotel>responsestrcture= new Responsestrcture<>();
		Hotel dbHotel = hoteldao.getHotelbyid(hid);
		if(dbHotel!=null) {
			hotel.setHotel_id(hid);
			responsestrcture.setMessage("Updated Sucssesfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<Responsestrcture<Hotel>>(responsestrcture,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
		
		
	}
	
	public ResponseEntity<Responsestrcture<Hotel>> deleteHotel(int hid) {
		Responsestrcture<Hotel> responsestrcture = new Responsestrcture<>();
		Hotel hotel = hoteldao.getHotelbyid(hid);
		if(hotel!=null) {
			responsestrcture.setMessage("deleted Successfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(hoteldao.deleteHotel(hid));
			
			return new ResponseEntity<Responsestrcture<Hotel>>(responsestrcture,HttpStatus.OK);
		}else {
			throw new Idnotfoundexception();
		}
	}
	
	public ResponseEntity<Responsestrcture<Hotel>> getHotelbyid(int hid) {
		Responsestrcture<Hotel>responsestrcture = new Responsestrcture<>();
		Hotel hotel = hoteldao.getHotelbyid(hid);
		if(hotel!=null) {
			responsestrcture.setMessage("Found Successfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(hoteldao.getHotelbyid(hid));
		
			return new ResponseEntity<Responsestrcture<Hotel>>(responsestrcture,HttpStatus.FOUND);
		}
		else { 
			throw new Idnotfoundexception();
		}
	}
	
}
