package com.cap.cb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.cb.entities.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {

	@Query(nativeQuery=true, value = "Delete from Cab where cabId= ?1")
	public Cab deleteByCabId(int cabId);
	
	List<Cab> findByCarType(String carType);

	@Query(nativeQuery=true, value="select count(*) from cab where car_type = ?1")
	public int countCabsOfType(String carType);
}
