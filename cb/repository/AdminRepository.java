package com.cap.cb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.cb.entities.Admin;
import com.cap.cb.entities.TripBooking;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query(nativeQuery = true, value="SELECT Trip_Booking.* from trip_booking  join driver on driver.driver_id= trip_booking.driver_id  order by cab_id")
	public List<TripBooking> findAllTripsByCabwise();
	
	@Query(nativeQuery = true, value="SELECT Trip_Booking.* from trip_booking  order by customer_id")
	public List<TripBooking> findAllTripsByCustomer();
	
	@Query(nativeQuery = true, value="SELECT Trip_Booking.* from trip_booking  order by from_date_time")
	public List<TripBooking> findAllTripsByDate();
	
	@Query(nativeQuery = true, value="SELECT Trip_Booking.* from trip_booking  where customer_id = ?1")
	public List<TripBooking> findAllTripsBycustomerId(int customerId);
}
