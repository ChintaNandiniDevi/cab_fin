package com.cap.cb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.cb.entities.Driver;


@Service
public interface DriverService {

	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	Driver deleteDriver(int driverId);
	List<Driver> viewBestDrivers();
	Driver viewDriver(int driverId);
}
