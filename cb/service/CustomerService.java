package com.cap.cb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.cb.entities.Customer;


@Service
public interface CustomerService {

	Customer insertCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer deleteCustomer(int customerId);
	List<Customer> viewCustomers();
	Customer viewCustomer(int customerId);
	Customer validateCustomer(String userName, String password);
}
