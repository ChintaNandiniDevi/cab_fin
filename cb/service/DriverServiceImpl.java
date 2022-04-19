package com.cap.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.cb.entities.Driver;
import com.cap.cb.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepo;
	
	@Override
	@Transactional
	public Driver insertDriver(Driver driver) {
		return driverRepo.save(driver);
	}

	@Override
	@Transactional
	public Driver updateDriver(Driver driver) {
		Driver rtnValue = driverRepo.findById(driver.getDriverId()).get();
		if(rtnValue != null) {
			rtnValue.setAddress(driver.getAddress());
			rtnValue.setCab(driver.getCab());
			rtnValue.setLicenceNo(driver.getLicenceNo());
			rtnValue.setMobileNumber(driver.getMobileNumber());
			rtnValue.setRating(driver.getRating());
			rtnValue.setTripBookings(driver.getTripBookings());
			rtnValue.setUemail(driver.getUemail());
			rtnValue.setUpassword(driver.getUpassword());
			rtnValue.setUserName(driver.getUserName());
			driverRepo.save(rtnValue);
		}
		return rtnValue;
	}

	@Override
	@Transactional
	public Driver deleteDriver(int driverId) {
		Driver rtnValue = driverRepo.findById(driverId).get();

		if(rtnValue != null) {
			driverRepo.delete(rtnValue);
		}
		return rtnValue;
	}

	@Override
	public List<Driver> viewBestDrivers() {
		return driverRepo.viewBestDrivers();
	}

	@Override
	public Driver viewDriver(int driverId) {
		return driverRepo.findById(driverId).get();
	}
}
