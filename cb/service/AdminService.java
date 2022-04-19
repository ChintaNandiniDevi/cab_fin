package com.cap.cb.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.cb.entities.Admin;
import com.cap.cb.entities.TripBooking;

@Service
public interface AdminService {

	 Admin insertAdmin(Admin admin);
	 Admin updateAdmin(Admin admin);
	 Admin deleteAdmin(int adminId);
	 List<TripBooking> getAllTrips(int customerId);
	 List<TripBooking> getTripsCabWise();
	 List<TripBooking> getTripsCustomerWise();
	 List<TripBooking> getTripsDateWise();
	 
}
