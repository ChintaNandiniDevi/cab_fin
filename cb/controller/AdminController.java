package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.cb.entities.Admin;
import com.cap.cb.entities.TripBooking;
import com.cap.cb.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping("/hello")
	public String someMethod() {
		System.out.println("*****");
		return "Hello World";
	}
	
	@PostMapping("/admin/add")
	Admin insertAdmin(@RequestBody Admin admin) {
		return service.insertAdmin(admin);
	}
	@PutMapping("/admin/update")
	Admin updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}
	@DeleteMapping("/admin/{adminId}")
	Admin deleteAdmin(@PathVariable int adminId) {
		return service.deleteAdmin(adminId);
	}
	
	@GetMapping("/admin/getTripsByCust/{customerId}")
	List<TripBooking> getAllTrips(@PathVariable int customerId){
		return service.getAllTrips(customerId);
	}
	@GetMapping("/admin/getCabTrips")
	List<TripBooking> getTripsCabWise(){
		return service.getTripsDateWise();
	}
	@GetMapping("/admin/getCustTrips")
	List<TripBooking> getTripsCustomerWise(){
		return service.getTripsCustomerWise();
	}
	@GetMapping("/admin/getDateWiseTrips")
	List<TripBooking> getTripsDateWise(){
		return service.getTripsDateWise();
	}
}
