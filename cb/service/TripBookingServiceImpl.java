package com.cap.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.cb.entities.TripBooking;
import com.cap.cb.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl implements TripBookingService {

	
	@Autowired
	TripBookingRepository tripRepo;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		return tripRepo.save(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		TripBooking rtnValue = tripRepo.findById(tripBooking.getTripBookingId()).get();
		if(rtnValue != null) {
			rtnValue.setTripBookingId(tripBooking.getTripBookingId());
			rtnValue.setCustomer(tripBooking.getCustomer());
			rtnValue.setDriver(tripBooking.getDriver());
			rtnValue.setToLocation(tripBooking.getToLocation());
			rtnValue.setFromLocation(tripBooking.getFromLocation());
			rtnValue.setFromDateTime(tripBooking.getFromDateTime());
			rtnValue.setToDateTime(tripBooking.getToDateTime());
			rtnValue.setStatus(tripBooking.isStatus());
			rtnValue.setDistanceInKm(tripBooking.getDistanceInKm());
			rtnValue.setBill(tripBooking.getBill());
			tripRepo.save(rtnValue);
		}
		return rtnValue;
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		TripBooking rtnValue= tripRepo.findById(tripBookingId).get();
		if(rtnValue != null)
			tripRepo.deleteById(tripBookingId);
		return rtnValue;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		return tripRepo.findAllTripsByCustomerId(customerId);
	}

	@Override
	public float calculateBill(int customerId) {
		return tripRepo.calculateBill(customerId);
	}

}
