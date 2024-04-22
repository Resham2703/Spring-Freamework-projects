 package com.jsp.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Admindao;
import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.exception.Idnotfoundexception;
import com.jsp.hotelmanagement.util.Responsestrcture;

@Service
public class Adminservice {

	@Autowired
	private Admindao admindao;
	Responsestrcture<Admin>responsestrcture = new Responsestrcture<>();
	
	public ResponseEntity<Responsestrcture<Admin>> saveAdmin(Admin admin , int hid) {
		Hotel hotel = admindao.getHotelById(hid);
		admin.setHotel(hotel);
		Admin admin2 = admindao.saveAdmin(admin);
		if(admin2!=null) {
			responsestrcture.setMessage("Save Data");
			responsestrcture.setStatus(HttpStatus.CREATED.value());
			responsestrcture.setData(admin2);
			return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.CREATED);
		}
		throw new Idnotfoundexception();

	}
	
	
	public ResponseEntity<Responsestrcture<Admin>> updateAdmin(Admin admin,int aid) {
		Admin dbAdmin = admindao.getAdminbyid(aid);
		admin.setHotel(dbAdmin.getHotel());
		admin.setAdmin_id(aid);
		responsestrcture.setMessage("Updated Data");
		responsestrcture.setStatus(HttpStatus.OK.value());
		responsestrcture.setData(admindao.updateAdmin(admin));
		return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture, HttpStatus.OK);

		
	}
	public ResponseEntity<Responsestrcture<Admin>> deleteAdmin(int aid) {
		Admin admin=admindao.getAdminbyid(aid);
		if(admin!=null) {
			responsestrcture.setMessage("Deleted Data");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.OK);
		}else{ 
			throw new Idnotfoundexception();

			
		}
	}
	public  ResponseEntity<Responsestrcture<Admin>>  getadminbyemail(String email) {
		Admin admin = admindao.getAdminbyemail(email);
		if(admin!=null) {
			responsestrcture.setMessage("FOund Sucssesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(admin);
			return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.FOUND);
		}
		throw new Idnotfoundexception();

	}
	public ResponseEntity<Responsestrcture<List<Admin>>> getAllAdmin(){
		Responsestrcture<List<Admin>>responsestrcture = new Responsestrcture<>();
		if(admindao.getalladmin()!=null) {
			responsestrcture.setMessage("Found Sucssesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(admindao.getalladmin());
			return new ResponseEntity<Responsestrcture<List<Admin>>>(responsestrcture,HttpStatus.FOUND);
			
		}
		throw new Idnotfoundexception();

	}
	
	public  ResponseEntity<Responsestrcture<Admin>> loginAdmin(String email , String password) {
		Admin admin = admindao.getAdminbyemail(email);
		if(admin.getAdmin_password().equals(password)) {
			responsestrcture.setMessage("Login Sucssesfull");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(admin);
			return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.OK);
		}else 
			responsestrcture.setMessage("Enter Valid Email and password");
		responsestrcture.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestrcture.setData(null);
		return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<Responsestrcture<Admin>> getAdminByid(int aid) {
		Admin admin = admindao.getAdminbyid(aid);
		if(admin != null) {
			responsestrcture.setMessage("Found Sucssesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(admin);
			return new ResponseEntity<Responsestrcture<Admin>>(responsestrcture,HttpStatus.FOUND);
		}		throw new Idnotfoundexception();

	}
	
}
