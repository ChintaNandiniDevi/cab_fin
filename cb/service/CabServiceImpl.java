package com.cap.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.cb.entities.Cab;
import com.cap.cb.repository.CabRepository;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	CabRepository cabRepo;
	
	@Override
	@Transactional
	public Cab insertCab(Cab cab) {
		return cabRepo.save(cab);
	}

	@Override
	@Transactional
	public Cab updateCab(Cab cab) {
		Cab rtnValue = cabRepo.findById(cab.getCabId()).get();
		if(rtnValue != null) {
			rtnValue.setCarType(cab.getCarType());
			rtnValue.setDriver(cab.getDriver());
			rtnValue.setPerKmRate(cab.getPerKmRate());
			cabRepo.save(rtnValue);
		}
		return rtnValue;
	}

	@Override
	@Transactional
	public Cab deleteCab(int cabId) {
		Cab rtnValue = cabRepo.findById(cabId).get();
		if(rtnValue != null) 
			cabRepo.delete(rtnValue);
		return rtnValue;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		
		return cabRepo.findByCarType(carType);
	}

	@Override
	public int countCabsOfType(String carType) {

		return cabRepo.countCabsOfType(carType);
	}

}
