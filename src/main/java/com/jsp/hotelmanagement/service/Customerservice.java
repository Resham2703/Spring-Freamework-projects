package com.jsp.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Customerdao;
import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.exception.Idnotfoundexception;
import com.jsp.hotelmanagement.util.Responsestrcture;

@Service
public class Customerservice {

	@Autowired
	private Customerdao customerdao;

	Responsestrcture<Customer> responsestrcture = new Responsestrcture<>();

	public ResponseEntity<Responsestrcture<Customer>> saveCostomer(Customer customer) {
		Customer dbCustomer = customerdao.saveCustomer(customer);
		if (dbCustomer != null) {
			responsestrcture.setMessage("Save Sucssesfully");
			responsestrcture.setStatus(HttpStatus.CREATED.value());
			responsestrcture.setData(dbCustomer);

			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.CREATED);
		} else {
			throw new Idnotfoundexception();
		}

	}

	public ResponseEntity<Responsestrcture<Customer>> updateCustomer(int cid, Customer customer) {
		Customer dbCustomer = customerdao.getCustomerbyid(cid);

		if (dbCustomer != null) {
			customer.setC_id(cid);
			responsestrcture.setMessage("updated it");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(customerdao.updateCustomer(customer));
			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.OK);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Customer>> deleteCustomer(int cid) {
		Customer customer = customerdao.getCustomerbyid(cid);
		if (customer != null) {
			responsestrcture.setMessage("Deleted sucssesfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(customerdao.deleteCustomer(customer));

			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.OK);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Customer>> getCustomerbyid(int cid) {
		Customer customer = customerdao.getCustomerbyid(cid);
		if (customer != null) {
			responsestrcture.setMessage("Found Sucssesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());// value(): finding value from database
			responsestrcture.setData(customer);
			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.FOUND);
		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<Customer>> getCustomerbyemail(String c_email) {
		Customer customer = customerdao.getCustomerbyemail(c_email);
		if (customer != null) {
			responsestrcture.setMessage("Found Sucssesfully");
			responsestrcture.setStatus(HttpStatus.FOUND.value());// value: finding value from database
			responsestrcture.setData(customer);
			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.FOUND);

		} else {
			throw new Idnotfoundexception();
		}
	}

	public ResponseEntity<Responsestrcture<List<Customer>>> getallCustomers() {

		Responsestrcture<List<Customer>> responsestrcture = new Responsestrcture<>();

		if (customerdao.getallCustomers() != null) {
			responsestrcture.setMessage("Found it");
			responsestrcture.setStatus(HttpStatus.FOUND.value());
			responsestrcture.setData(customerdao.getallCustomers());
			return new ResponseEntity<Responsestrcture<List<Customer>>>(responsestrcture, HttpStatus.FOUND);

		}
		throw new Idnotfoundexception();
	}

	// Log In Phase...
	public ResponseEntity<Responsestrcture<Customer>> loginCustomer(String email, String password) {
		Customer customer = customerdao.getCustomerbyemail(email);
		if (customer.getC_password().equals(password)) {
			responsestrcture.setMessage("log in sucssesfully");
			responsestrcture.setStatus(HttpStatus.OK.value());
			responsestrcture.setData(customer);
			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.OK);
		} else {
			responsestrcture.setMessage("enter valid email and password");
			responsestrcture.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestrcture.setData(null);
			return new ResponseEntity<Responsestrcture<Customer>>(responsestrcture, HttpStatus.BAD_REQUEST);
		}
	}
}
