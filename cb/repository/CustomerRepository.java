package com.cap.cb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.cb.entities.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer c where c.userName =: userNamea and c.upassword =: passworda")
	public Customer validateCustomer(String userNamea, String passworda);
}
