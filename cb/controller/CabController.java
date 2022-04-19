package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.cb.entities.Cab;
import com.cap.cb.service.CabService;

@RestController
public class CabController {
	@Autowired
	private CabService service;
	
	@PostMapping("/cab/add")
	Cab insertCab(@RequestBody Cab cab) {
		return service.insertCab(cab);
	}
	@PutMapping("/cab/upate")
	Cab updateCab(@RequestBody Cab cab) {
		return service.updateCab(cab);
	}
	@DeleteMapping("/cab/delete/{cabId}")
	Cab deleteCab(@PathVariable int cabId) {
		return service.deleteCab(cabId);
	}
	@GetMapping("/cab/viewTypes/{carType}")
	List<Cab> viewCabsOfType(@PathVariable String carType){
		return service.viewCabsOfType(carType);
	}
	@GetMapping("/cab/countType/{carType}")
	int countCabsOfType(@PathVariable String carType) {
		return service.countCabsOfType(carType);
	}
}
