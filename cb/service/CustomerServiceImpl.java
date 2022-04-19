package com.cap.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cap.cb.entities.Customer;
import com.cap.cb.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	@Transactional
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer rtnValue = customerRepo.findById(customer.getCustomerId()).get();
		if(rtnValue != null) {
			rtnValue.setAddress(customer.getAddress());
			rtnValue.setMobileNumber(customer.getMobileNumber());
			rtnValue.setTripBooking(customer.getTripBooking());
			rtnValue.setUemail(customer.getUemail());
			rtnValue.setUpassword(customer.getUpassword());
			rtnValue.setUserName(customer.getUserName());
			customerRepo.save(rtnValue);
		}
		return rtnValue;
	}

	@Override
	@Transactional
	public Customer deleteCustomer(int customerId) {
		Customer customer = customerRepo.findById(customerId).get();
		if(customer != null)
			customerRepo.delete(customer); 
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return customerRepo.findById(customerId).get();
	}

	@Override
	public Customer validateCustomer(String userName, String password) {
		
		return customerRepo.validateCustomer(userName, password);
	}
}
