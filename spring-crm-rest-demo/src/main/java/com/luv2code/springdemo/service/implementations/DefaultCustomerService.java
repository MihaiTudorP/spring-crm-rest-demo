package com.luv2code.springdemo.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.repositories.CustomerRepository;
import com.luv2code.springdemo.service.CustomerService;

@Service
public class DefaultCustomerService implements CustomerService {

	// need to inject customer dao
	private CustomerRepository customerRepository;
	
	@Autowired
	public DefaultCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Optional<Customer> result = customerRepository.findById(id);
		if (result.isPresent()) return result.get();
		return null;
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
}





