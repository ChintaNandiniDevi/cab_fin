package com.cap.cb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.cb.entities.Cab;

@Service
public interface CabService {
	Cab insertCab(Cab cab);
	Cab updateCab(Cab cab);
	Cab deleteCab(int cabId);
	List<Cab> viewCabsOfType(String carType);
	int countCabsOfType(String carType);
}