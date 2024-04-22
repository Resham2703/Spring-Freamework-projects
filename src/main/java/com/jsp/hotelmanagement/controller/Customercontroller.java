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

import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.service.Customerservice;
import com.jsp.hotelmanagement.util.Responsestrcture;

@RestController
@RequestMapping("customer")
public class Customercontroller {

	@Autowired
	private Customerservice customerservice;

	@PostMapping
	public ResponseEntity<Responsestrcture<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerservice.saveCostomer(customer);
	}

	@PutMapping
	public ResponseEntity<Responsestrcture<Customer>> updateCustomer(@RequestBody Customer customer, @RequestParam int cid) {
		return customerservice.updateCustomer(cid, customer);
	}

	@DeleteMapping
	public ResponseEntity<Responsestrcture<Customer>> deleteCustomer(@RequestParam int cid) {
		return customerservice.deleteCustomer(cid);
	}

	@GetMapping("/getCustomerbyid")
	public ResponseEntity<Responsestrcture<Customer>> getCustomerbyid(@RequestParam int cid) {
		return customerservice.getCustomerbyid(cid);
	}
	
	@GetMapping("/getCustomerbyemail") 
	public ResponseEntity<Responsestrcture<Customer>> getCustomerbyemail(@RequestParam String cid) {
		return customerservice.getCustomerbyemail(cid);
	}
	@GetMapping("/getallCustomers")
	public ResponseEntity<Responsestrcture<List<Customer>>>getallCustomers(){
		return customerservice.getallCustomers();
	}

}
