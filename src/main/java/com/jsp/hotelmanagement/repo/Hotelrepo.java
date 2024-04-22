package com.jsp.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotelmanagement.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer>{

	
	
}
