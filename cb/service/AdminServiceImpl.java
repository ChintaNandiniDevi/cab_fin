package com.cap.cb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.cb.entities.Admin;
import com.cap.cb.entities.TripBooking;
import com.cap.cb.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	@Transactional
	public Admin insertAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

	@Override
	@Transactional
	public Admin updateAdmin(Admin admin) {
		
		Admin rtnValue = adminRepo.findById(admin.getAdminId()).get();
		if(rtnValue != null) {
			rtnValue.setAddress(admin.getAddress());
			rtnValue.setMobileNumber(admin.getMobileNumber());
			rtnValue.setUemail(admin.getUemail());
			rtnValue.setUserName(admin.getUserName());
			rtnValue.setUpassword(admin.getUpassword());
			adminRepo.save(rtnValue);
		}
		return rtnValue;
	}

	@Override
	@Transactional
	public Admin deleteAdmin(int adminId) {
		Admin rtnValue = adminRepo.findById(adminId).get();
		if(rtnValue != null) 
			adminRepo.deleteById(adminId);
		return rtnValue;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		return adminRepo.findAllTripsBycustomerId(customerId);
	}

	@Override
	public List<TripBooking> getTripsCabWise() {

		return adminRepo.findAllTripsByCabwise();
	}

	@Override
	public List<TripBooking> getTripsCustomerWise() {
		return adminRepo.findAllTripsByCustomer();
	}

	@Override
	public List<TripBooking> getTripsDateWise() {
		return adminRepo.findAllTripsByDate();
	}
}
