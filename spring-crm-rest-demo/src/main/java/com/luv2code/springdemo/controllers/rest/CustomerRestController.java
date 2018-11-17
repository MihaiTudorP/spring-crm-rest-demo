/**
 * 
 */
package com.luv2code.springdemo.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all-customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}

}
