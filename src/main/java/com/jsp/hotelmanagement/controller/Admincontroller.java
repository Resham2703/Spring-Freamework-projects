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

import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.service.Adminservice;
import com.jsp.hotelmanagement.util.Responsestrcture;

@RestController
@RequestMapping("/Admin")
public class Admincontroller {

	@Autowired
	private Adminservice adminservice;

	@PostMapping
	public ResponseEntity<Responsestrcture<Admin>> saveAdmin(@RequestBody Admin admin, @RequestParam int hid) {
		return adminservice.saveAdmin(admin, hid);
	}

	@PutMapping
	public ResponseEntity<Responsestrcture<Admin>> updateAdmin(@RequestParam Admin admin, @RequestParam int aid) {
		return adminservice.updateAdmin(admin, aid);
	}

	@DeleteMapping
	public ResponseEntity<Responsestrcture<Admin>> deleteAdmin(@RequestParam int aid) {
		return adminservice.deleteAdmin(aid);
	}

	@GetMapping("/getadminbyemail")
	public ResponseEntity<Responsestrcture<Admin>> getAdminbyemail(@RequestParam String email) {
		return adminservice.getadminbyemail(email);
	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity<Responsestrcture<List<Admin>>> getAllAdmin() {
		return adminservice.getAllAdmin();
	}

	@GetMapping("/loginAdmin")
	public ResponseEntity<Responsestrcture<Admin>> loginAdmin(@RequestParam String email, @RequestParam String password) {
		return adminservice.loginAdmin(email, password);
	}
	@GetMapping("adminByid") 
	public ResponseEntity<Responsestrcture<Admin>> getAdminByid(@RequestParam int aid) {
		return adminservice.getAdminByid(aid);
	}
}
