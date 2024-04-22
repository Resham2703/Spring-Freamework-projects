package com.jsp.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagement.dto.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.c_email=?1")
	public Customer getCustomerbyemail(String c_email);
}

 