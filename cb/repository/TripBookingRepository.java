package com.cap.cb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cap.cb.entities.TripBooking;


//@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{

	@Query(nativeQuery = true, value="SELECT Trip_Booking.* from trip_booking  where customer_id = ?1")
	List<TripBooking> findAllTripsByCustomerId(int customerId);
	
	@Query(nativeQuery = true, value="select sum(bill) from trip_booking where customer_id = ?1")
	Float calculateBill(int customerId);
}
