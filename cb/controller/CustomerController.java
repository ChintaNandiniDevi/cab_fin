package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.cb.entities.Customer;
import com.cap.cb.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer/add")
	Customer insertCustomer(@RequestBody Customer customer) {
		return service.insertCustomer(customer);
	}
	@PutMapping("/customer/update")
	Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@DeleteMapping("/customer/del/{customerId}")
	Customer deleteCustomer(@PathVariable int customerId) {
		return service.deleteCustomer(customerId);
	}
	@GetMapping("/customer/viewAll")
	List<Customer> viewCustomers(){
		return service.viewCustomers();
	}
	@GetMapping("/customer/view/{customerId}")
	Customer viewCustomer(int customerId) {
		return service.viewCustomer(customerId);
	}
	@GetMapping("/customer/validate/{userName}/{password}")
	Customer validateCustomer(String userName, String password) {
		return service.validateCustomer(userName, password);
	}
}
