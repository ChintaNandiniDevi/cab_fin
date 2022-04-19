package com.cap.cb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.cb.entities.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("Select driver from Driver driver where driver.rating >=4.5 ")
	public List<Driver> viewBestDrivers();
}
