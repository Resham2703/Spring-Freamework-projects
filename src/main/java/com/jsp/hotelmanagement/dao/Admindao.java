package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.repo.Adminrepo;

@Repository
public class Admindao {

	@Autowired
	private Adminrepo adminrepo;

	public Admin saveAdmin(Admin admin) {
		return adminrepo.save(admin);
	}

	public Admin updateAdmin(Admin admin) {
		return adminrepo.save(admin);
	}

	public Admin deleteAdmin(Admin admin) {
		adminrepo.delete(admin);
		return admin;
	}

	public Admin getAdminbyid(int aid) {
		if (adminrepo.findById(aid).isPresent()) {
			return adminrepo.findById(aid).get();
		}

		return null;
	}

	public List<Admin> getalladmin() {
		return adminrepo.findAll();
	}

	public Admin getAdminbyemail(String admin_email) {
		if (adminrepo.getAdminByEmail(admin_email) != null) {
			return adminrepo.getAdminByEmail(admin_email);
		}
		return null;
	}

	public Hotel getHotelById(int hid) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
