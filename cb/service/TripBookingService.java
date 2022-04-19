package com.cap.cb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.cb.entities.TripBooking;

@Service
public interface TripBookingService {
	TripBooking insertTripBooking(TripBooking tripBooking);
	TripBooking updateTripBooking(TripBooking tripBooking);
	TripBooking deleteTripBooking(int tripBookingId);
	List<TripBooking> viewAllTripsCustomer(int customerId);
	float calculateBill(int customerId);
}