/**
 * 
 */
package com.luv2code.springdemo.controllers.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.controllers.rest.exceptionhandlers.exceptions.CustomerNotFoundException;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		logger.info("Fetching all customers and returning them");
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		logger.info("Retrieving customer by id: [{}]", customerId);
		final Customer customer;
		try{
			customer= customerService.getCustomer(customerId);
		} catch (EntityNotFoundException e) {
			final String customerNotFoundMessage = String.format("Customer with id [%d] not found.", customerId);
			logger.info(customerNotFoundMessage);
			throw new CustomerNotFoundException(customerNotFoundMessage);
		}
		logger.info("Customer retrieved: [{}]", customer);
		return customer;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
		logger.info("Attempting to save customer: [{}]", customer);
		try {
			customerService.saveCustomer(customer);
		} catch (Exception e) {
			logger.info("Failed to save customer: [{}]", customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Saved customer [{}]", customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer){
		if (customer.getId()==0) return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
		logger.info("Attempting to update customer: [{}]", customer);
		try {
			customerService.saveCustomer(customer);
		} catch (Exception e) {
			logger.info("Failed to update customer: [{}]", customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Updated customer [{}]", customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
		logger.info("Attempting to delete the customer with id: [{}]", id);
		Customer c = customerService.getCustomer(id);
		if (c==null) {
			logger.info("Could not find the customer with id: [{}]", id);
			return new ResponseEntity<String> ("Customer not found", HttpStatus.NOT_FOUND);
		}
		
		customerService.deleteCustomer(id);
		logger.info("Deleted the customer with id: [{}]", id);
		return new ResponseEntity<String> (String.format("Deleted customer id: %d", id), HttpStatus.OK);
	}
}