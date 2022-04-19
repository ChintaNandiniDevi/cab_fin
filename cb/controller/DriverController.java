package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cap.cb.entities.Driver;
import com.cap.cb.service.DriverService;

public class DriverController {

	@Autowired
	private DriverService service;
	@PostMapping("/driver/add")
	Driver insertDriver(@RequestBody Driver driver) {
		return service.insertDriver(driver);
	}
	@PutMapping("/driver/update")
	Driver updateDriver(@RequestBody Driver driver) {
		return service.updateDriver(driver);
	}
	@GetMapping("/driver/get/{driverId}")
	Driver deleteDriver(@PathVariable int driverId) {
		return service.deleteDriver(driverId);
	}
	@GetMapping("/driver/best")
	List<Driver> viewBestDrivers(){
		return service.viewBestDrivers();
	}
	@GetMapping("/driver/view/{driverId}")
	Driver viewDriver(@PathVariable int driverId) {
		return service.viewDriver(driverId);
	}
	
}
