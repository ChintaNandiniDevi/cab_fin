package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cap.cb.entities.TripBooking;
import com.cap.cb.service.TripBookingService;

public class TripBookingController {
	
	@Autowired
	private TripBookingService service;
	@PostMapping("/tripBooking/add")
	TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return service.insertTripBooking(tripBooking);
	}
	@PutMapping("/tripBooking/update")
	TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return service.updateTripBooking(tripBooking);
	}
	@DeleteMapping("/tripBooking/del/{tripBookingId}")
	TripBooking deleteTripBooking(@PathVariable int tripBookingId) {
		return service.deleteTripBooking(tripBookingId);
	}
	@GetMapping("/tripBooking/view/{customerId}")
	List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId){
		return service.viewAllTripsCustomer(customerId);
	}
	@GetMapping("/tripBooking/cal/{customerId}")
	float calculateBill(@PathVariable int customerId) {
		return service.calculateBill(customerId);
	}
}
