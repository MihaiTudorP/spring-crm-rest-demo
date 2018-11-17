package com.luv2code.springdemo.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.repositories.CustomerRepository;
import com.luv2code.springdemo.service.CustomerService;

@Service
public class DefaultCustomerService implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {	
		return customerRepository.getOne(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
}





